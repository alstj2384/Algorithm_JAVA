package 백준.자바.부분합_1806;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] d = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N+1; i++)
            d[i] = d[i - 1] + Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 1;
        int dist = Integer.MAX_VALUE;
        while(right <= N){
            if(left > N) break;

            int diff = d[right] - d[left];
            if(S <= diff){
                dist = Math.min(dist, right-left);
                left++;
            }
            else{
                right++;
            }
        }
        System.out.println(dist == Integer.MAX_VALUE ? 0 : dist);
        br.close();
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}