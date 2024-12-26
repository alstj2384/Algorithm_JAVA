package 백준.자바._1로만들기_1463;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1,000,000
        // 연산 사용 횟수의 최솟값
        // Top - down + Memoization
        int x = sc.nextInt();
        int[] dp = new int[x + 1];

        for(int i = 2; i <= x; i++){
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        System.out.println(dp[x]);
    }
}
