package SWEA.식료품가게_19113;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    // 할인된 가격표랑 할인 안 된 가격표 두개를 각각 뽑음
    // 얘네를 한번에 오름차순으로 정렬해버림
    //
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++){
            sb.append("#"+t+" ");
            int N = Integer.parseInt(br.readLine());

            boolean[] check = new boolean[N*2];
            long[] arr = new long[N*2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0 ; i < N*2; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }

            for(int i = 0; i < N*2; i++){
                if(check[i]) continue;

                long normalPrice = (arr[i]*4L)/3L;
                for(int j = 0; j < N*2; j++){
                    if(!check[j] && arr[j] == normalPrice){
                        check[j] = true;
                        check[i] = true;
                        sb.append(arr[i] + " ");
                        break;
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

}
