package SWEA.View_1206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++){
            sb.append("#" + test_case + " ");

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];

            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            for(int i = 2; i < N - 2; i++){
                int max = 0;
                max = Math.max(arr[i-2], max);
                max = Math.max(arr[i-1], max);
                max = Math.max(arr[i+1], max);
                max = Math.max(arr[i+2], max);

                sum += Math.max(arr[i] - max, 0);
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}