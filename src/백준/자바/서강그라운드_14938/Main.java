package 백준.자바.서강그라운드_14938;


import java.io.*;
import java.util.*;

public class Main {
    private int N, M, R;
    private int[][] map;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        int[] items = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            items[i] = Integer.parseInt(st.nextToken());

        for(int i =0; i < N; i++){
            Arrays.fill(map[i], 100_000_000);
            map[i][i] = 0;
        }
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = c;
            map[b][a] = c;
        }

        //플로이드워셜
        for(int i = 0; i < N; i++){
            for(int a = 0; a < N; a++){
                for(int b = 0; b < N; b++){
                    map[a][b] = Math.min(map[a][b], map[a][i]+map[i][b]);
                }
            }
        }

        int answer= 0;
        for(int i = 0; i < N; i++){
            int sum = 0;
            for(int j = 0; j < N; j++){
                if(map[i][j] <= M){
                    sum += items[j];
                }
            }
            answer = Math.max(sum, answer);
        }

        System.out.println(answer);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
