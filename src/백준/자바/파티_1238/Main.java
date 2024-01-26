package 백준.자바.파티_1238;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken())-1;

        int[][] arr = new int[N][N];

        // 각 노드 최댓값으로 초기화
        for(int i = 0; i < N; i++){
            Arrays.fill(arr[i], 1_000_000_000);
            arr[i][i] = 0;
        }

        // 입력 받기
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            arr[a][b] = Integer.parseInt(st.nextToken());
        }

        // 플로이드 워셜 알고리즘 수행
        for(int i = 0; i < N; i++){
            for(int a = 0; a < N; a++){
                for(int b = 0; b < N; b++)
                    arr[a][b] = Math.min(arr[a][b], arr[a][i]+arr[i][b]);
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++)
            max = Math.max(arr[i][X] + arr[X][i], max);
        System.out.println(max);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
