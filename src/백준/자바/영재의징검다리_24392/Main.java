package 백준.자바.영재의징검다리_24392;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

//        long[][] dp = new long[1001][1002];
        long[][] dp = new long[n+1][m+2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < m+1; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = 1; j <= m; j++){
                if(dp[i][j] == 1){
                    dp[i][j] = (dp[i+1][j-1] + dp[i+1][j] + dp[i+1][j+1]) % 1_000_000_007;
//                    System.out.println("few" + dp[i+1][j-1]+ " " + dp[i+1][j] + " " + dp[i+1][j+1]);
                }
            }
        }

//        for(var p : dp){
//            for(var q : p){
//                System.out.print(q + " ");
//            }
//            System.out.println();
//        }

        long sum = 0;
        for(var p : dp[0]){
            sum += p;
        }
        System.out.println(sum % 1_000_000_007);


    }
}
