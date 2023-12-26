package 백준.자바.LCS_9251;

import java.io.*;
import java.util.*;

public class Main {
    // 이 부분에 static으로 사용 할 멤버 선언
    // private int max = 0; ...
    // private int[] arr; ...
    // private void dfs()...
    private int[][] arr;

    public void solution() throws Exception{
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int n = s1.length()+1;
        int m = s2.length()+1;
        arr = new int[n][m];
        int max = 0;

        for(int i = 1; i < n; i++ ){
            for(int j = 1; j < m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1]+1;
                }
                else{
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
                if(arr[i][j] > max) max = arr[i][j];
            }
        }

        System.out.println(max);

    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}