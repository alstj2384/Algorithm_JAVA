package 백준.자바.오르막수_11057;

import java.io.*;
import java.util.*;

public class Main {

    private int N;
    private int[][] arr;


    public void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][10];

        for(int i = 0; i < 10; i++) arr[0][i] = i + 1;

        for(int i = 1; i < N; i++){
            for(int j =0; j < 10; j++){
                if(j == 0) arr[i][j] = 1;
                else arr[i][j] = (arr[i-1][j] + arr[i][j-1])%10007;
            }
        }

        System.out.println(arr[N-1][9]);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
