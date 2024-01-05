package 백준.자바.종이의개수_1780;


import java.io.*;
import java.util.*;

public class Main {
    private int[][] arr;
    private int zero = 0;
    private int minus = 0;
    private int one = 0;
    int dfs(int x, int y, int size){
        int dist = size/3;
        int val[] = new int[9];
        if(size == 1) return arr[x][y];

        int[] dx = {0, 0, 0, dist, dist, dist, dist*2, dist*2, dist*2};
        int[] dy = {0, dist, dist*2, 0, dist, dist*2, 0, dist, dist*2};
        for(int i = 0; i < 9; i++){
            val[i] = dfs(x+dx[i], y+dy[i], dist);
        }

        int tmp = val[0];
        int count = 0;
        for(var k : val){
            if(tmp == k) count++;
        }
        if(count == 9){
            return val[0];
        }
        else{
            for(var k : val){
                if(k == Integer.MAX_VALUE) continue;
                if(k == -1) minus++;
                else if(k == 0) zero++;
                else one++;
            }
        }
        return Integer.MAX_VALUE;


    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int tmp = 0;
        if((tmp = dfs(0, 0, n)) == 0){
            zero++;
        }
        else if(tmp == 1)
            one++;
        else if(tmp == -1)
            minus++;

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}