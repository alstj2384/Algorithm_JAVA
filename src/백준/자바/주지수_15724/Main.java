package 백준.자바.주지수_15724;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];

        // 입력 받기
        for(int i = 1 ; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < M+1; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        // 누적 합 구하기
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < M+1; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + arr[i][j];
            }
        }

        // 값 계산
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(arr[x2][y2] - ((arr[x2][y1-1] + arr[x1-1][y2]) - arr[x1-1][y1-1])).append('\n');
        }
        System.out.println(sb);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
