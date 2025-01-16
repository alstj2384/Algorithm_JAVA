package 백준.자바._1로만들기_1463;

import java.util.Scanner;

public class newMain {
    static int[] dp = new int[1000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bottom up
        int x = sc.nextInt();
        for(int i = 2; i <= x; i++){
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }

        System.out.println(dp[x]);

    }
}
