package 백준.자바.파이프옮기기1_17070;

import java.io.*;
import java.util.*;

public class Main {
    private int N;
    // true = 벽
    private boolean[][] arr;
    private int count;
    private boolean checkEnd(Pair p){
        if(!(p.x == N-1 && p.y == N-1)) return false;
        count += 1;
        return true;
    }
    private boolean checkDiagonal(Pair p){
        if(p.x+1 >= N || p.y+1 >= N) return false;
        return !arr[p.x+1][p.y] && !arr[p.x][p.y+1] && !arr[p.x+1][p.y+1];
    }
    private boolean checkFront(Pair p, int state){
        if(state == 0) {
            if(p.y+1 >= N) return false;
            return !arr[p.x][p.y + 1];
        }
        if(p.x+1 >= N) return false;
        return !arr[p.x+1][p.y]; // 세로
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j < N; j++)
                arr[i][j] = st.nextToken().equals("1");
        }
        if(arr[N-1][N-1]){
            System.out.println(0);
            return;
        }

        Queue<Pipe> q = new LinkedList<>();
        q.offer(new Pipe(new Pair(0, 1), 0));

        // 가로, 세로, 대각선
        int[] dx = {0, 1, 1};
        int[] dy = {1, 0, 1};

        Pair next;
        while(!q.isEmpty()) {
            Pipe p = q.poll();

            // 대각선인 경우
            if (p.state == 2) {
                if (checkFront(p.head, 0)) {
                    next = new Pair(p.head.x + dx[0], p.head.y+dy[0]);
                    if(checkEnd(next)) continue;
                    q.offer(new Pipe(next, 0));
                }
                if (checkFront(p.head, 1)) {
                    next = new Pair(p.head.x + dx[1], p.head.y + dy[1]);
                    if(checkEnd(next)) continue;
                    q.offer(new Pipe(next, 1));
                }
            }
            // 가로 혹은 세로인 경우
            else {
                if (checkFront(p.head, p.state)){
                    next = new Pair(p.head.x + dx[p.state], p.head.y+dy[p.state]);
                    if(checkEnd(next)) continue;
                    q.offer(new Pipe(next, p.state));
                }
            }
            if (checkDiagonal(p.head)) {
                next = new Pair(p.head.x + dx[2], p.head.y + dy[2]);
                if(checkEnd(next)) continue;
                q.offer(new Pipe(next, 2));
            }
        }

        System.out.println(count);
        }

    class Pipe{
        Pair head;
        int state;
        // 0 = 가로, 1 = 세로, 2 = 대각선
        public Pipe(Pair h, int s){
            head = h;
            state = s;
        }
    }

    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y =y;
        }
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
