package 백준.자바.벽부수고이동하기2_14442;


import java.io.*;
import java.util.*;

public class Main {

    private int N, M, K;
    private char[][] arr;
    private boolean[][][] visited;
    private Queue<Pair> q = new LinkedList<>();
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    class Pair{
        int x;
        int y;
        int count;
        int broken;

        public Pair(int x, int y, int count, int broken) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.broken = broken;
        }
    }

    int bfs(){

        q.add(new Pair(0, 0, 1, 0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();

            if(p.x == N-1 && p.y == M-1) return p.count;
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(arr[nx][ny] == '1'){
                    // 깰 수 있을 때
                    if(p.broken < K && !visited[p.broken+1][nx][ny]){
                        q.add(new Pair(nx, ny, p.count+1, p.broken+1));
                        visited[p.broken+1][nx][ny] = true;
                    }
                }
                // 0일 때
                else{
                    if(!visited[p.broken][nx][ny]) {
                        q.add(new Pair(nx, ny, p.count + 1, p.broken));
                        visited[p.broken][nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[K+1][N][M];
        arr = new char[N][M];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++)
                arr[i][j] = s.charAt(j);
        }

        System.out.println(bfs());



    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
