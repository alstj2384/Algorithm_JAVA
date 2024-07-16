package 백준.자바.쿼드트리_1992;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class newMain {
    static int[][] map;
    static StringBuilder sb;

    static boolean checkSame(int row, int col, int size){
        int color = map[row][col];

        for(int i = row; i < row+size; i++){
            for(int j = col; j < col+size; j++){
                if(color != map[i][j]) return false;
            }
        }
        return true;
    }

    static void compress(int row, int col, int size){

        if(checkSame(row, col, size)){
            sb.append(map[row][col]);
            return;
        }

        sb.append('(');
        int newSize = size/2;
        compress(row, col, newSize);
        compress(row, col + newSize, newSize);
        compress(row + newSize, col, newSize);
        compress(row + newSize, col + newSize, newSize);
        sb.append(')');
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        sb = new StringBuilder();
        for(int i = 0 ; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }
        compress(0, 0, n);
        System.out.println(sb);
    }
}
