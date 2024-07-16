package 백준.자바.색종이만들기_2630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int white, blue;
    static int[][] map;

    static boolean colorCheck(int row, int col, int size){
        int color = map[row][col];

        for(int i = row; i < row+size; i++){
            for(int j = col; j < col+size; j++){
                if(map[i][j] != color)
                    return false;
            }
        }
        return true;
    }
    static void devide(int row, int col, int size){

        if(colorCheck(row, col, size)){
            if(map[row][col] == 0) white++;
            else blue ++;
            return;
        }

        int newSize = size/2;
        devide(row, col, newSize);
        devide(row,col+newSize, newSize);
        devide(row + newSize,col, newSize);
        devide(row + newSize,col+newSize, newSize);


    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        white = 0;
        blue = 0;
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        devide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }
}
