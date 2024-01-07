package 백준.자바.벽부수고이동하기_2206;


import java.io.*;
import java.util.*;

public class Main {

    private boolean[][][] visited;
    private int[][] arr;
    private int N, M;
    private LinkedList<Pair> q = new LinkedList<>();
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    // arr = [N+1][M+1]

    class Pair{
        int x;
        int y;
        int count;
        boolean isSmashed;

        public Pair(int x, int y, int count, boolean isSmashed) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isSmashed = isSmashed;
        }
    }
    int bfs(){

        q.add(new Pair(1, 1, 1, false));
        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.x == N && p.y == M)
                min = Math.min(min, p.count);

            if(p.isSmashed){
                if(!visited[1][p.x][p.y]){
                    visited[1][p.x][p.y] = true;
                    for (int i = 0; i < 4; i++) {
                        int nx = p.x + dx[i];
                        int ny = p.y + dy[i];

                        if (nx >= 1 && ny >= 1 && nx < N + 1 && ny < M + 1) {
                            if (arr[nx][ny] == 0)
                                q.add(new Pair(nx, ny, p.count + 1, true));
                        }
                    }
                }
            }
            if(!p.isSmashed) {
                if (!visited[0][p.x][p.y]) {
                    visited[0][p.x][p.y] = true;
                    visited[1][p.x][p.y] = true;
                    for (int i = 0; i < 4; i++) {
                        int nx = p.x + dx[i];
                        int ny = p.y + dy[i];

                        if (nx >= 1 && ny >= 1 && nx < N + 1 && ny < M + 1) {
                            if (arr[nx][ny] == 1)
                                q.add(new Pair(nx, ny, p.count + 1, true));
                            else if (arr[nx][ny] == 0)
                                q.add(new Pair(nx, ny, p.count + 1, false));
                        }
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        visited = new boolean[2][N+1][M+1];

        for(int i = 1; i < N+1; i++){
            String s = br.readLine();
            for(int j = 1; j < M+1; j++)
                arr[i][j] = s.charAt(j-1)-'0';
        }
        System.out.println(bfs());
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
