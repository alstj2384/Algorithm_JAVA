package 백준.자바.카드구매하기_11052;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N+1];
        int[] cards = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                if(j > i) break;
                d[i] = Math.max(d[i], d[i-j]+cards[j]);
            }
        }
        System.out.println(d[N]);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}

