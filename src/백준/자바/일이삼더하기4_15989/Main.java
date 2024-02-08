package 백준.자바.일이삼더하기4_15989;

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
        d[3] = 3;

        for(int i = 4; i < max+1; i++){
            d[i] = d[i-3] + (int)Math.floor(i/2) + 1;
        }

        for(var k : T)
            System.out.println(d[k]);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
