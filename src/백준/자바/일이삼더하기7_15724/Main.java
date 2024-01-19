package 백준.자바.일이삼더하기7_15724;

import java.io.*;
import java.util.*;

public class Main {
    private int N, M, count;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] d = new int[1001][1001];

        d[1][1] = 1;
        d[2][1] = 1;
        d[2][2] = 1;
        d[3][1] = 1;
        d[3][2] = 2;
        d[3][3] = 1;

        int k = Integer.parseInt(br.readLine());

        for(int i = 4; i < 1001; i++){
            for(int j  =1 ; j < 1001; j++){
                d[i][j] = ((d[i-1][j-1] + d[i-2][j-1])%1000000009 + d[i-3][j-1]) % 1000000009;
            }
        }

        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            count = 0;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sb.append(d[N][M]).append('\n');
        }
        System.out.println(sb);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
