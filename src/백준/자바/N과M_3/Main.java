package 백준.자바.N과M_3;

import java.io.*;
import java.util.*;

public class Main {
    private int n;
    private int m;
    private int[] arr;
    //    private int tmp = 0;
    private static StringBuilder sb = new StringBuilder();
    //    private boolean[] visited;
    void dfs(int count){
        if(count == m){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i = 0; i < n; i++){
//            if(!visited[i]) {
//                visited[i] = true;
            arr[count] = i+1;
//                tmp = i+1;
            dfs(count+1);
//                visited[i] = false;
//            }
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정적변수 N과 M을 초기화해준다.
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
//        visited = new boolean[n];
        dfs(0);
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
