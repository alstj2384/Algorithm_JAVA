package 백준.자바.암호코드_2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = (" " + br.readLine()).toCharArray();

        int[] dp = new int[s.length];

        dp[0] = 1;

        for(int i = 1; i < s.length; i++){
            int c = s[i] - '0';
            if(1 <= c && c <= 9){
                dp[i] += dp[i-1];
                dp[i] %= 1000000;
            }

            if(i == 1) continue;

            if(s[i-1] == '0') continue;

            c = ((s[i-1]-'0') * 10) + s[i] - '0';
            if(10 <= c && c <= 26){
                dp[i] += dp[i-2];
                dp[i] %= 1000000;
            }
        }

        System.out.println(dp[s.length-1]);
    }
}
