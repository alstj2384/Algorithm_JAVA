package 백준.자바.동전1_2293;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n+1];
        int[] d = new int[k+1];
        for(int i = 1; i < n+1; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        d[0] = 1;
        for(int i = 1 ; i < n+1; i++){
            for(int j = coin[i]; j < k+1; j++){
                d[j] += d[j-coin[i]];
            }
        }
        System.out.println(d[k]);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
