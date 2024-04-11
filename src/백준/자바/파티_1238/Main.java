package 백준.자바.파티_1238;

import java.io.*;
import java.util.*;

public class Main {
    private int N, M, X;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];

        for(int i = 0; i < N+1; i++){
            Arrays.fill(map[i], 100_000_000);
            map[i][i] = 0;
        }


        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            map[start][end] = dist;
        }

        // 플로이드 워셜
        for(int k = 1; k < N+1; k++){
            for(int a = 1; a < N+1; a++){
                for(int b = 1; b < N+1; b++){
                    map[a][b] = Math.min(map[a][b], map[a][k]+map[k][b]);
                }
            }
        }
        int result = 0;
        for(int i = 1; i < N+1; i++){
            result = Math.max(result, map[i][X] + map[X][i]);
        }

        System.out.println(result);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
