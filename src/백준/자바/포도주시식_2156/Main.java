package 백준.자바.포도주시식_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];

        for(int i = 1 ; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[3][n+1];

        dp[1][1] = arr[1];
        for(int i = 2; i < n+1; i++){;
            dp[0][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1]));
            dp[1][i] = dp[0][i-1] + arr[i];
            dp[2][i] = dp[1][i-1] + arr[i];
        }

//        for(var p : dp){
//            for(var q : p){
//                System.out.print(q + " ");
//            }
//            System.out.println();
//        }
        System.out.println(Math.max(dp[0][n], Math.max(dp[1][n], dp[2][n])));
    }
}
