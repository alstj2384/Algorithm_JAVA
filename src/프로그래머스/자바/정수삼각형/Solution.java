package 프로그래머스.자바.정수삼각형;
import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][];

        int N = triangle.length;
        for(int i = 0; i < N; i++){
            dp[i] = new int[i+1];
        }

        dp[0][0] = triangle[0][0];
        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                for(int k = j; k < j+2; k++){
                    dp[i][k] = Math.max(dp[i][k], triangle[i][k] + dp[i-1][j]);
                }
            }
        }

        Arrays.sort(dp[N-1]);
        answer = dp[N-1][N-1];

        return answer;
    }
}