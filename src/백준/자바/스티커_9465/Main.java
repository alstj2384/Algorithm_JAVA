package 백준.자바.스티커_9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[3][n+1];

            for(int i = 0; i < 2; i++){
                StringTokenizer st= new StringTokenizer(br.readLine());
                for(int j = 1 ; j < n+1; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[3][n+1];
            for(int i = 1; i <= n; i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + arr[1][i];
                dp[2][i] = Math.max(dp[0][i-1], dp[1][i-1]);
            }


            System.out.println(Math.max(dp[0][n], dp[1][n]));


        }
    }
}
