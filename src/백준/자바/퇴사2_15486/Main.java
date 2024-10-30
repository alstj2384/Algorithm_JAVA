package 백준.자바.퇴사2_15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] day = new int[N+1];
        int[] pay = new int[N+1];

        int[] dp = new int[N+2];

        for(int i  =1; i < N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            day[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

//        for (int i : day) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//
//        for (int i : pay) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        for(int i  =1 ;i < N+1; i++){
            dp[i] = Math.max(dp[i-1], dp[i]);
            if(i + day[i] <= N+1){
                dp[i + day[i]] = Math.max(dp[i+day[i]] , dp[i] + pay[i]);
            }
        }
//
//        for (int i : dp) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        Arrays.sort(dp);
        System.out.println(dp[N+1]);
    }
}
