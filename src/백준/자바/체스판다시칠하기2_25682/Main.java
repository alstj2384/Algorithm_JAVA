package 백준.자바.체스판다시칠하기2_25682;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, M, K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];

        for(int i = 1; i < N+1; i++){
            String s = br.readLine();
            for(int j = 1; j < M+1; j++){
                map[i][j] = s.charAt(j-1) == 'B' ? 1 : 0;
            }
        }
        // B이면 1, W이면 0을 저장


        int[][][] psum = new int[2][N+1][M+1];
        // 0 = 왼쪽 위가 W인 경우 : (i + j) % 2 == 0이면 map[i][j] == 0, else 1
        // 1 = 왼쪽 위가 B인 경우 : (i + j) % 2 == 0이면 map[i][j] == 1, else 0

        for(int k = 0; k < 2; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < M + 1; j++) {
                    if((i + j) % 2 == 0){
                        if(map[i][j] != k) psum[k][i][j] = 1;
                    } else{
                        if(map[i][j] == k) psum[k][i][j] = 1;
                    }
                }
            }
        }

        // 2차원 구간합 구하기
        for(int k = 0; k < 2; k++){
            for(int i = 1; i < N + 1; i++){
                for(int j = 1; j < M + 1; j++){
                    psum[k][i][j] = psum[k][i][j] + psum[k][i-1][j] + psum[k][i][j-1] - psum[k][i-1][j-1];
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for(int k = 0; k < 2; k++) {
            for (int i = K; i < N + 1; i++) {
                for (int j = K; j < M + 1; j++) {
                    int val = psum[k][i][j] - psum[k][i-K][j] - psum[k][i][j-K] + psum[k][i-K][j-K];
                    result = Math.min(val, result);
                }
            }
        }

        System.out.println(result);
    }
}

