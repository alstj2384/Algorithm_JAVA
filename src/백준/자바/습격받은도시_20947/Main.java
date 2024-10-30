package 백준.자바.습격받은도시_20947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] possible;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static void dfs_x(int row, int col, int dir){
    }


    static void dfs_y(int row, int col, int dir){
        while(true){
            row = row + dx[dir];
            col = col + dy[dir];

            if(row < 0 || col < 0 || row >= N || col >= N || map[row][col] == 'O' || map[row][col] == 'X'){
                return;
            }
            map[row][col] = '.';
        }
    }

    static void check4Dir_x(int row, int col){
        for(int i = 0; i < 4; i++){
            dfs_x(row, col, i);
        }
    }


    static void check4Dir_y(int row, int col){
        for(int i = 0; i < 4; i++){
            dfs_y(row, col, i);
        }
    }
    static void simulate(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 'X')
                    check4Dir_x(i, j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 'O')
                    check4Dir_y(i, j);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        possible = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = s.charAt(j);
            }
        }

        simulate();

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }



    }
}
