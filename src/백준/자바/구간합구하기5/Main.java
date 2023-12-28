package 백준.자바.구간합구하기5;

import java.io.*;
import java.util.*;

public class Main {
    private int n, m;
    private int[][] arr;
    private int[][] d;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        d = new int[n+1][n+1];

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++)
                d[i][j] = d[i-1][j] + d[i][j-1] - d[i-1][j-1] + arr[i-1][j-1];
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(d[x2][y2] - (d[x1-1][y2] + d[x2][y1-1]-d[x1-1][y1-1]) );
        }

    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}