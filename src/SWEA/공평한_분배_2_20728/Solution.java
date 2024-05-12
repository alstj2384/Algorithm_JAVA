package SWEA.공평한_분배_2_20728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int N, K;
        for(int t = 1; t < T+1; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken()) - 1;

            st = new StringTokenizer(br.readLine());
            List<Integer> arr = new ArrayList<>();

            for(int i = 0; i < N; i++){
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(arr, Collections.reverseOrder());

            int index = 0;
            int min = Integer.MAX_VALUE;
            while(index + K < N){
                min = Math.min(arr.get(index) - arr.get(index+K), min);
                index++;
            }
            System.out.println("#"+t+" " + min);
        }

    }
}
