package 백준.자바.체스판다시칠하기_1018;

import java.io.*;
import java.util.*;

public class Main {
    private char[][] arr;
    int isChessBoard(int x, int y, char c){
        int count = 0;
        for(int i =x; i < x+8; i++){
            for(int j = y; j < y+8; j++){
                if(c == arr[i][j])
                    count++;
                if(j != y+7)
                    c = c == 'W' ? 'B' : 'W';
            }
        }
        return count;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++)
                arr[i][j] = s.charAt(j);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N-7; i++)
            for(int j = 0; j < M-7; j++) {
                min = Math.min(min, isChessBoard(i, j, 'W'));
                min = Math.min(min, isChessBoard(i, j, 'B'));
            }

        System.out.println(min);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}

