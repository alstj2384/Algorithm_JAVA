package 백준.자바.비숍_1799;

import java.io.*;
import java.util.*;

public class Main {
    private int N, nx, ny, w_max = Integer.MIN_VALUE, b_max = Integer.MIN_VALUE;
    private int[][] map;
    private boolean[][] black_visit, white_visit;
    private int[] dx = {-1, -1, 1, 1};
    private int[] dy = {-1, 1, -1, 1};



    private void black_dfs(int x, int y, int count){
        b_max = Math.max(count, b_max);

        if(y>= N){
            x++;
            y = x%2==1?1:0;
        }
        if(x >= N) return;

        if(Check(black_visit, x, y)){
            black_visit[x][y] = true;
            black_dfs(x, y+2, count+1);
            black_visit[x][y] = false;
        }
        black_dfs(x, y+2, count);
    }


    private void white_dfs(int x, int y, int count){
        w_max = Math.max(count, w_max);

        if(y>= N){
            x++;
            y = x%2==1?0:1;
        }
        if(x >= N) return;

        if(Check(white_visit, x, y)){
            white_visit[x][y] = true;
            white_dfs(x, y+2, count+1);
            white_visit[x][y] = false;
        }
        white_dfs(x, y+2, count);
    }

    private boolean Check(boolean[][] visited, int x, int y){
        if(map[x][y] == 0) return false;
        for(int i =0; i <4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            for (int j = 0; j < N; j++) {
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (visited[nx][ny]) return false;

                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }
        return true;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i =0 ;i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        black_visit = new boolean[N][N];
        white_visit = new boolean[N][N];

        black_dfs(0, 0, 0);
        white_dfs(0, 1, 0);

        System.out.println(b_max+ w_max);


    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
