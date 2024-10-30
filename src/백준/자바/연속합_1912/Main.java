package 백준.자바.연속합_1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] dp = new Integer[N+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[1] = arr[1];
        for(int i = 2; i < N+1; i++){
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
        }

//        for (Integer integer : dp) {
//            System.out.print(integer + " ");
//        }
//        System.out.println();
        Arrays.sort(dp, 1, N+1, (x, y) -> y - x);


        System.out.println(dp[1]);

    }
}
