package 백준.자바.스도쿠_2580;

import java.io.*;
import java.util.*;

public class Main {
    private int[][] arr;
    private boolean isFinished;

    boolean checkRow(int x, int k){
        // 행에서 k와 같은 값이 있을 경우 return false
        for(int i = 0; i < 9; i++)
            if(arr[x][i] == k) return false;
        return true;
    }

    boolean checkCol(int y, int k){
        for(int i = 0; i < 9; i++)
            if(arr[i][y] == k) return false;
        return true;
    }

    boolean checkSquare(int x, int y, int k){
        int xStart = 0;
        if(x >= 0 && x < 3) xStart = 0;
        else if(x >= 3 && x < 6) xStart = 3;
        else if(x >= 6 && x < 9) xStart = 6;

        int yStart = 0;
        if(y >= 0 && y < 3) yStart = 0;
        else if(y >= 3 && y < 6) yStart = 3;
        else if(y >= 6 && y < 9) yStart = 6;

        for(int i = xStart; i < xStart+3; i++){
            for(int j = yStart; j < yStart+3; j++){
                if(arr[i][j] == k) return false;
            }
        }
        return true;
    }

    // x, y는 arr와 같은 인덱스임
    void dfs(int x, int y){
        // 이전 재귀에서 답을 찾을 경우 다른 재귀 스킵
        if(isFinished) return;

        if(x == 9 && y == 0) {
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    if(checkRow(i, arr[i][j]) && checkCol(j, arr[i][j]) && checkSquare(i, j, arr[i][j])){
                        return;
                    }
                }
            }
            isFinished = true;
            for(var k : arr){
                for(var q : k)
                    System.out.print(q+" ");
                System.out.println();
            }
            return;
        }

        // 해당 칸이 0일 경우, 체크 수행
        if(arr[x][y] == 0){
            // 0~9까지 모두 탐색, arr index = 0~8, 실제 arr 값 = 1~9
            for(int i = 1; i < 10; i++){
                if(checkRow(x, i) && checkCol(y, i) && checkSquare(x, y, i)){
                    arr[x][y] = i;
                    if((y+1)%9 == 0) dfs(x+1, 0);
                    else dfs(x, y+1);
                    arr[x][y] = 0;
                }
            }
        }
        // 1~9일 경우, 다음 칸으로 넘어감
        else{
            if((y+1)%9 == 0) dfs(x+1, 0);
            else dfs(x, y+1);
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];
        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}