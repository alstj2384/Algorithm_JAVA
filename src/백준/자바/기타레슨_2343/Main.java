package 백준.자바.기타레슨_2343;

import java.io.*;
import java.util.*;

public class Main {
    private int[] arr;
    private int N, M;

    boolean check(int x){
        int max = 0, sum = 0, blueRays = 0;
        for(int i = 0; i < N; i++){
            if(sum + arr[i] <= x)
                sum += arr[i];
            else {
                blueRays++;
                if(blueRays >= M || arr[i] > x) return false;
                max = Math.max(max, sum);
                sum = arr[i];
            }
        }
        max = Math.max(max, sum);
        return max <= x;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int lo = 0;
        int hi = 1_000_000_001;
        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            if(check(mid)) hi = mid;
            else lo = mid;
        }
        System.out.println(hi);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}