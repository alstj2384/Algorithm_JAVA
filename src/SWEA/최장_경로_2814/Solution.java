package SWEA.최장_경로_2814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static List<List<Integer>> graph;
    static boolean[] visited ;
    static int max = Integer.MIN_VALUE;
    static void dfs(int x, int count){
        visited[x] = true;
        for (Integer integer : graph.get(x)) {
            if(!visited[integer]){
                dfs(integer, count+1);
                visited[integer] = false;
            }
        }
        max = Math.max(max, count);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t= 1; t <= T; t++){
            sb.append("#"+t+" ");

            max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();

            for(int i = 0; i < N; i++){
                graph.add(new ArrayList<>());
            }
            visited = new boolean[N];
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;

                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            for(int i = 0; i < N; i++){
                dfs(i, 1);
                visited[i] = false;
            }
            sb.append(max).append('\n');
        }
        System.out.print(sb);
    }
}
