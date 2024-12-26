package 백준.자바._123더하기_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());

            System.out.println(dp[N]);

        }

    }
}
