package 백준.자바.택배_1719;


import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

public class Main {
    private int N, M;
    private int[][] map;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        int[][] record = new int[N+1][N+1];
        for(int i = 0; i < N+1; i++) {
            Arrays.fill(map[i], 100_000_000);
            map[i][i] = 0;
            for(int j = 0; j < N+1; j++){
                record[i][j] = j;
            }
        }


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            map[a][b] = s;
            map[b][a] = s;
        }

        for(int k = 1; k < N+1; k++){
            for(int a = 1; a < N+1; a++){
                for(int b = 1; b < N+1; b++){
                    if(map[a][b]> map[a][k]+map[k][b]) {
                        map[a][b] = map[a][k] + map[k][b];
                        record[a][b] = record[a][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                if(i==j) {
                    sb.append('-').append(' ');
                    continue;
                }
                sb.append(record[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);



    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
