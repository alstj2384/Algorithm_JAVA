package 백준.자바.내리막길_1520;

import java.io.*;
import java.util.*;

public class Main {
    private int N, M, count, nx, ny;
    private int[][] map, dp;
    private int[] dx = {1, -1 ,0, 0};
    private int[] dy = {0, 0 ,1, -1};


    private int dfs(int x, int y){
        if(x == N-1 && y == M-1) {
            return 1;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }

        dp[x][y] = 0;
        for(int i = 0; i <4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(map[x][y] > map[nx][ny])
                dp[x][y] += dfs(nx, ny);
        }
        return dp[x][y];
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i =0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }


        dp = new int[N][M];
        for(int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);


        dfs(0, 0);

        System.out.println(dp[0][0]);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
