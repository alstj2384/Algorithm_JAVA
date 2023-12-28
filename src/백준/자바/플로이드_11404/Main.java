package 백준.자바.플로이드_11404;

import java.io.*;
import java.util.*;

public class Main {
    private int n, m;
    private int[][] arr;

    void floyd(){
        for(int k = 1; k < n+1; k++)
            for(int a = 1; a < n +1; a++)
                for(int b = 1; b < n+1; b++)
                    arr[a][b] = Math.min(arr[a][b] , arr[a][k] + arr[k][b]);
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                arr[i][j] = 10000001;
                if(i == j) arr[i][j] = 0;
            }
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(arr[a][b] > c) arr[a][b] = c;
        }

        floyd();

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++) {
                if(arr[i][j] == 10000001)
                    System.out.print(0 + " ");
                else System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}