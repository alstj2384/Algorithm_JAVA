package 백준.자바.쿼드트리_1992;


import java.io.*;
import java.util.*;

public class Main {
    // 이 부분에 static으로 사용 할 멤버 선언
    // private int max = 0; ...
    // private int[] arr; ...
    private int n;
    private int[][] arr;

    private String dfs(int x, int y, int size){
        if(size == 1)
            return ""+arr[x][y];
        // x, y 는 중심 좌표
        //왼쪽위, 오른쪽위, 왼쪽아래, 오른쪽아래
        String a = dfs(x, y, size/2);
        String c = dfs(x+size/2, y, size/2);
        String b = dfs(x, y+size/2, size/2);
        String d = dfs(x+size/2, y+size/2, size/2);

        if(a.equals("1") && b.equals("1") && c.equals("1") && d.equals("1")){
            return "1";
        }

        if(a.equals("0") && b.equals("0") && c.equals("0") && d.equals("0")){
            return "0";
        }
        return "("+a+b+c+d+")";

    }
    // dfs(3, 7, 8)

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0 ; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }
        System.out.println(dfs(0, 0, n));
    }
    public static void main(String[] args) throws Exception{
        new 백준.자바.쿼드트리_1992.Main().solution();
    }
}
