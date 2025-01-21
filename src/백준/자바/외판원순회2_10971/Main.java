package 백준.자바.외판원순회2_10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] w;
    static int n;
    static int min;
    static boolean[] visited = new boolean[10];
    static void dfs(int x, int dist, int depth, int dest){
        if(depth == n){
            if(x == dest) {
                min = Math.min(dist, min);
            }
            return;
        }
        int[] curNode = w[x];
        for(int i = 0; i < curNode.length; i++){
            if(!visited[i] && curNode[i] != 0){
                visited[i] = true;
                dfs(i, dist + curNode[i], depth+1, dest);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        dfs(0, 0, 0, 0);
        System.out.println(min);
    }
}
