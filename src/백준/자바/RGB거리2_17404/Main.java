package 백준.자바.RGB거리2_17404;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] RGB = new int[N][3];
        int[][] d = new int[N][3];

        for(int i  =0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3; j++)
                RGB[i][j] = Integer.parseInt(st.nextToken());
        }

        int total = Integer.MAX_VALUE;
        for(int i =0 ; i < 3; i++){
            for(int k = 0; k < 3; k++){
                if(i == k) d[0][k] = RGB[0][k];
                else d[0][k] = 1001;
            }

            for(int j = 1; j < N; j++){
                d[j][0] = Math.min(d[j-1][1], d[j-1][2])+RGB[j][0];
                d[j][1] = Math.min(d[j-1][0], d[j-1][2])+RGB[j][1];
                d[j][2] = Math.min(d[j-1][0], d[j-1][1])+RGB[j][2];
            }

            int t = Integer.MAX_VALUE;
            for(int k = 0; k < 3; k++){
                if(i==k) continue;
                if(t > d[N-1][k]) t = d[N-1][k];
            }

            total = Math.min(t, total);
        }

        System.out.println(total);


    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
