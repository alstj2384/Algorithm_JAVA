package 백준.자바.일이삼더하기삼_15988;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];


        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            T[i] = Integer.parseInt(br.readLine());
            max = Math.max(T[i], max);
        }

        int[] d = new int[max+1];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for(int i = 4; i < max+1; i++){
            d[i] = ((d[i-3] % 1000000009 + d[i-2] % 1000000009) % 1000000009 + d[i-1]) % 1000000009;
        }

        for(var k : T)
            System.out.println(d[k]);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
