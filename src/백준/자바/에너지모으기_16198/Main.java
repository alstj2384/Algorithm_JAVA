package 백준.자바.에너지모으기_16198;

import java.io.*;
import java.util.*;

public class Main {

    private boolean[] visited;
    private int[] arr;
    private int max;
    void dfs(int depth, int val){
        if(depth == arr.length-2){
            max = Math.max(val, max);
            return;
        }
        for(int i = 1; i < arr.length-1; i++){
            if(visited[i]) continue;
            int left = i-1;
            int right = i+1;
            while(visited[left])
                left--;
            while(visited[right])
                right++;

            visited[i] = true;
            dfs(depth+1, val+arr[left] * arr[right]);
            visited[i] = false;
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);
        System.out.println(max);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
