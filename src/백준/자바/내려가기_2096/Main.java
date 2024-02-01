package 백준.자바.내려가기_2096;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] nums = new int[N+1][3];
        int[][][] d = new int[2][N+1][3];

        for(int i = 1; i < N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nums[i][0] = a; nums[i][1] = b; nums[i][2] = c;
        }
        // 0 = 최솟값, 1 = 최댓값
        for(int i = 1; i < N+1; i++){
            d[0][i][0] = Math.min(d[0][i-1][0], d[0][i-1][1]) + nums[i][0];
            d[0][i][1] = Math.min(d[0][i-1][2], Math.min(d[0][i-1][0], d[0][i-1][1]))+ nums[i][1];
            d[0][i][2] = Math.min(d[0][i-1][1], d[0][i-1][2])+ nums[i][2];

            d[1][i][0] = Math.max(d[1][i-1][0], d[1][i-1][1])+ nums[i][0];
            d[1][i][1] = Math.max(d[1][i-1][2], Math.max(d[1][i-1][0], d[1][i-1][1]))+ nums[i][1];
            d[1][i][2] = Math.max(d[1][i-1][1], d[1][i-1][2])+ nums[i][2];
        }
        int min = Math.min(d[0][N][0], Math.min(d[0][N][1], d[0][N][2]));
        int max = Math.max(d[1][N][0], Math.max(d[1][N][1], d[1][N][2]));

        System.out.println(max + " " + min);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
