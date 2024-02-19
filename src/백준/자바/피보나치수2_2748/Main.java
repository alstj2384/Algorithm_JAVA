package 백준.자바.피보나치수2_2748;

import java.io.*;
import java.util.*;

public class Main {
    private long[] dp;
    private long fibonacci(int x){
        if(dp[x] == -1)
            return dp[x] = fibonacci(x-1) + fibonacci(x-2);
        return dp[x];
    }
    public void solution() throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dp = new long[n+1];

        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 1;

        System.out.println(fibonacci(n));
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
