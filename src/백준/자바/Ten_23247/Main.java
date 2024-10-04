package 백준.자바.Ten_23247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];

        for(int i = 1; i < N+1; i++){
            st=  new StringTokenizer(br.readLine());
            for(int j = 1; j < M+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 구하기
        int[][] dSum = new int[N+1][M+1];
        // 2차원 평면 누적합 = dSum[i][j] = dSum[i-1][j] + dSum[i][j-1] - dSum[i-1][j-1] + map[i][j];
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < M+1; j++){
                dSum[i][j] = dSum[i-1][j] + dSum[i][j-1] - dSum[i-1][j-1] + map[i][j];
            }
        }

        int count = 0;
        // 누적합으로 모든 경우 고려하여 10이 되는 경우 찾기
        // 사각형 크기는 최대 10
        for(int i = 1; i < N+1; i++){
            for(int j= 1; j < M+1; j++){

                for(int p = i; p < Math.min(N+1, i+10); p++){
                    for(int q = j; q < Math.min(M+1, j+10); q++){
                        int val = dSum[p][q] - (dSum[p][j-1] + dSum[i-1][q] - dSum[i-1][j-1]);
                        if(val == 10) count += 1;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
