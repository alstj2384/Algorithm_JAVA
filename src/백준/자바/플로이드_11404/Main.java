package 백준.자바.플로이드_11404;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] floyd = new int[N+1][N+1];

        for(int i = 0; i < N+1; i++){
            Arrays.fill(floyd[i], 100_000_000);
            floyd[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            floyd[a][b] = Math.min(floyd[a][b], c);
        }
        // k, a, b = 1 to n+1
        for(int k = 1; k < N+1; k++){
            for(int a = 1; a < N+1; a++){
                for(int b = 1; b < N+1; b++){
                    floyd[a][b] = Math.min(floyd[a][b], floyd[a][k] + floyd[k][b]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                if(floyd[i][j] == 100_000_000) sb.append("0 ");
                else sb.append(floyd[i][j] + " ");
            }
            sb.append('\n');
        }

        System.out.print(sb);


    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
