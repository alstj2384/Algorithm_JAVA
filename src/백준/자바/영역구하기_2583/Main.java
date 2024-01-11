package 백준.자바.영역구하기_2583;


import java.io.*;
import java.util.*;

public class Main {
    private int N, M, K;
    private int[][] arr;
    private Queue<pair> q;
    private boolean[][] visited;
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    class pair{
        int x;
        int y;
        public pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    int bfs(int x, int y){
        q = new LinkedList<>();
        q.add(new pair(x, y));
        int count = 0;

        while(!q.isEmpty()){
            pair p = q.poll();

            if(visited[p.x][p.y] || arr[p.x][p.y] == 1) continue;
            count++;

            visited[p.x][p.y] = true;

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || arr[nx][ny] == 1) continue;
                q.add(new pair(nx, ny));
            }
        }
        return count;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    arr[j][i] = 1;
                }
            }
        }
        Vector<Integer> v = new Vector<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int c = bfs(i, j);
                if(c!= 0)
                    v.add(c);
            }
        }
        Collections.sort(v);
        System.out.println(v.size());
        for(var k : v){
            System.out.print(k + " ");
        }
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
