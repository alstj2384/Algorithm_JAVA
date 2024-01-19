package 백준.자바.랜선자르기_1654;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    private int K, N;
    private int[] arr;


    boolean Check(long x){
        // 결정 문제 : 모든 랜선을 x 길이로 잘랐을 때 얻을 수 있는 랜선의 수가 N보다 같거나 큰가
        // Check(x) = false인 경우, x의 길이로 잘랐을 때 N보다 적은 개수로 잘리게 됨
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


        // lo : 0으로 나눌 수 없으므로 1부터
        // Check(lo) = 1의 길이로 모든 랜선을 자르므로, 적어도 n개 이상으로 잘림, True
        // hi : 2^31-1 = Integer.MAXVALUE, 오버플로우를 고려하여 Long.MAX_VALUE로 설정
        // Long.MAX_VALUe = 2^63-1이므로, 이분 탐색 횟수는 63회 이하
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