package SWEA.최빈수_구하기_1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb=  new StringBuilder();
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            sb.append("#" + N + " ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[101];

            for(int i = 0; i < 1000; i++){
                int score = Integer.parseInt(st.nextToken());
                arr[score]++;
            }

            int value = 0;
            int index = 0;
            for(int i = 0; i < 101; i++){
                if(value <= arr[i]){
                    value = Math.max(value, arr[i]);
                    index = i;
                }
            }
            sb.append(index).append('\n');
        }
        System.out.print(sb);
    }
}