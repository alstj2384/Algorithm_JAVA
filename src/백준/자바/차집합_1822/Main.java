package 백준.자바.차집합_1822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }


        StringBuilder sb = new StringBuilder();
        Arrays.sort(A);
        Arrays.sort(B);

        int count = 0;

        for(int i = 0 ; i < N; i++){
            // A[i] 원소로 B에 대한 이분탐색 수행, 없으면 추가

            int k = Arrays.binarySearch(B, A[i]);
//            System.out.println(k);
            if(k < 0) {
                count += 1;
                sb.append(A[i] + " ");
            }


        }

        if(count == 0){
            System.out.println(0);
        } else {
            System.out.println(count);
            System.out.println(sb);
        }

    }
}
