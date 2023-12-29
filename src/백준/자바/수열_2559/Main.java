package 백준.자바.수열_2559;

import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] d = new int[n+1];

        d[1] = arr[1];
        for(int i = 2; i < n+1; i++) d[i] = arr[i] + d[i-1];

        // 누적합 = d[i] - d[i-3] .. 3은 이제 떨어진정도..
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < n+1; i++){
            if(i-1 + (m) < n) sum = Math.max(sum, d[i+(m)]-d[i]);
        }

        System.out.println(sum);

    }

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
