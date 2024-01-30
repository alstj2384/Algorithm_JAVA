package 백준.자바.평범한배낭_12865;

import java.io.*;
import java.util.*;

public class Main {
    private final int WEIGHT = 0;
    private final int VALUE = 1;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] d = new int[N+1][K+1];
        int[][] item = new int[N+1][2];

        for(int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            item[i][WEIGHT] = Integer.parseInt(st.nextToken());
            item[i][VALUE] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N+1; i++){ // 고려중인 물건
            for(int w = 1; w < K+1; w++){ // 사용 가능한 배낭의 용량
                if(item[i][WEIGHT] > w){ // 현재 고른 물건의 무게가 배낭 용량보다 크면
                    d[i][w] = d[i-1][w];
                }else{
                    d[i][w] = Math.max(d[i-1][w], d[i-1][w-item[i][WEIGHT]]+item[i][VALUE]);
                }
            }
        }

        System.out.println(d[N][K]);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
