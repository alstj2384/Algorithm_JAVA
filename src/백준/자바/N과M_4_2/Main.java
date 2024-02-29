package 백준.자바.N과M_4_2;

import java.io.*;
import java.util.*;

public class Main {
    int N, M;
    int[] arr;
    StringBuilder sb = new StringBuilder();
    private void dfs(int at, int count){
        if(count >= M){
            for(var k : arr){
                sb.append(k).append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i = at; i < N+1; i++){
            arr[count] = i;
            dfs(i, count+1);
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);
        System.out.print(sb);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
