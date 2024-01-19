package 백준.자바.랜선자르기_1654;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    private int K, N;
    private int[] arr;
    boolean Check(long x){
        long result = 0;
        for(int i = 0; i< K; i++){
            result += arr[i] / x;
        }
        return result >= N;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 입력 받기
        arr = new int[K];
        for (int i = 0; i < K; i++)
            arr[i] = Integer.parseInt(br.readLine());

        long lo = 1;
        long hi = Long.MAX_VALUE-1;

        while(lo + 1 < hi){
            long mid = (lo + hi) / 2;
            if(Check(mid)) lo = mid;
            else hi = mid;
        }

        // 탐색 결과
        // lo = N개 이상의 랜선을 자를 수 있는 값중 최댓값
        // hi = N개 이상의 랜선을 자를 수 없게 되는 값중 최솟값

        System.out.println(lo);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}