package 백준.자바.합구하기_11441;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] d = new int[n+1];

        for (int i = 1; i < n + 1; i++)
            d[i] = d[i-1] + Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(d[b]-d[a-1]).append('\n');
        }
        System.out.println(sb);


    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
