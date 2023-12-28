package 백준.자바.케빈베이컨의6단계법칙_1389;

import java.io.*;
import java.util.*;

public class Main {
    // 이 부분에 static으로 사용 할 멤버 선언
    // private int max = 0; ...
    // private int[] arr; ...
    // private void dfs()...
    private int n, m;
    private int[][] arr;
    private boolean[] visited; // visited 크기는 i+1로
    private Queue<Pair> q;
    class Pair{
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

    }


    Pair bfs(int start){
        int sum= 0;

        q = new LinkedList<>();

        q.add(new Pair(start, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            if(!visited[node]) {
                visited[node] = true;
                sum += p.dist;

                for (int i = 1; i < n+1; i++)
                    if (arr[node][i] != 0 && !visited[i])
                        q.add(new Pair(i, p.dist + 1));
            }
        }
        return new Pair(start, sum);
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        Pair result = new Pair(101, Integer.MAX_VALUE);
        for(int i = 1; i < n+1; i++){
            visited = new boolean[n+1];
            Pair p = bfs(i);
            if(result.dist > p.dist) result = p;
            else if(result.dist == p.dist){
                if(result.node > p.node){
                    result = p;
                }
            }
        }
        System.out.println(result.node);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}