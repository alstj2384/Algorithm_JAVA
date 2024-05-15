package SWEA.백만_장자_프로젝트_1859;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb=  new StringBuilder();
        for(int t = 1; t <= T; t++){
            sb.append("#" + t + " ");
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // 오른쪽부터 왼쪽으로 한 칸씩 처리하면 될듯

            int value = arr[N-1];
            Long sum = 0L;
            for(int i = N-1; i >= 0; i--){
                if(arr[i] > value){
                    value = arr[i];
                }
                sum += value - arr[i];
            }

            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}
