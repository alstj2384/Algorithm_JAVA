package 백준.자바.종이의개수_1780;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class newMain {
    static int[][] map;
    static int minus, zero, one;

    static boolean checkSame(int row, int col, int size){
        int number = map[row][col];

        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(number != map[i][j]) return false;
            }
        }
        return true;
    }

    static void cut(int row, int col, int size){

        if(checkSame(row, col, size)){
            int val = map[row][col];

            if(val == -1) minus += 1;
            else if(val == 0) zero += 1;
            else one += 1;

            return;
        }

        int newSize = size/3;

        cut(row, col, newSize);
        cut(row, col + newSize, newSize);
        cut(row, col + newSize * 2, newSize);
        cut(row + newSize, col, newSize);
        cut(row + newSize, col + newSize, newSize);
        cut(row + newSize, col + newSize * 2, newSize);
        cut(row + newSize * 2, col, newSize);
        cut(row + newSize * 2, col + newSize, newSize);
        cut(row + newSize * 2, col + newSize * 2, newSize);


    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        minus = zero = one = 0;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);

    }
}
