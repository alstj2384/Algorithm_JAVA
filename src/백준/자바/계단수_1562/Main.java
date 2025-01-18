package 백준.자바.계단수_1562;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[][][] dp = new long[n+1][11][1<<10];

        for(int i = 1; i < 10; i++){
            dp[1][i][1<<i] = 1;
            // 10, 100, 1000, 10000, ...
        }

        for(int i = 2; i < n+1; i++){
            for(int k = 0; k < 10; k++){
                for(int bit = 0; bit < 1<<10; bit++){
                    if(k == 0)
                        dp[i][k][bit | (1 << k)] += dp[i-1][k+1][bit];
                    else if(k == 9)
                        dp[i][k][bit | (1 << k)] += dp[i-1][k-1][bit];
                    else
                        dp[i][k][bit | (1<<k)] += dp[i-1][k+1][bit] + dp[i-1][k-1][bit];

                    dp[i][k][bit | (1<<k)] %= 1000000000;
                }
            }
        }

        long count = 0;
        for(int i = 0; i <= 9; i++){
            count += dp[n][i][1023];
            count %= 1000000000;
        }
        System.out.println(count);
    }
}
