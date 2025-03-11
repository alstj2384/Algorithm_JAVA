package 백준.자바.줄어들지않아_2688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        long[][] dp = new long[11][65];

        for(int i = 1; i < 11; i++){
            dp[i][0] = 1;
        }

        for(int a = 1; a < 65; a++) {
            for (int i = 1; i < 11; i++) {
                dp[i][a] = dp[i-1][a] + dp[i][a-1];
            }
        }

        for(int i = 0; i < t; i++){
            int x = Integer.parseInt(br.readLine());

            long sum = 0L;
            for(int b = 1; b < 11; b++){
                sum += dp[b][x-1];
            }
            System.out.println(sum);

        }
    }
}
