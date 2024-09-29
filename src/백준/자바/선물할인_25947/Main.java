package 백준.자바.선물할인_25947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, A;
        long B;

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        A = Integer.parseInt(st.nextToken());

        long[] arr = new long[N+1];
        long[] dSum = new long[N+1];
        long[] halfDSum = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);


        for(int i = 1; i < N+1; i++){
            dSum[i] = dSum[i-1] + arr[i];
            halfDSum[i] = halfDSum[i-1] + arr[i]/2;
        }

        int k = 0;
        boolean isEnd = false;
        while(k < A){
            k++;
            if(halfDSum[k] - halfDSum[0] > B){
                k--;
                isEnd = true;
                break;
            }
        }
        // 중간에 탈출되는 경우 k -> 고려 x
        // 끝까지 간 경우
        // -> N == A인 경우

        int p = 0; // 제 값주고 사는 경우의 범위
        if(isEnd || k == N) // 반 값으로 a개 이상 고르지 못한 경우, 제 값으로 더 살 수 있는 경우는 없다
            System.out.println(k);
        else{ // a개까진 고를 수 있는 경우이므로, halfDSum[k] - halfDSum[k-A] 가능.

            // 제 값을 주고 살 수 있는 경우 고려
            while(k < N){
                p++;
                k++;
                long price = dSum[p] - dSum[0] + halfDSum[k] - halfDSum[k-A];
                if(price > B){
                    System.out.println(--k);
                    isEnd = true;
                    break;
                }
            }
            if(!isEnd)
                System.out.println(k);
        }


    }
}
