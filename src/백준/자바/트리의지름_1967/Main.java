package 백준.자바.트리의지름_1967;

import java.io.*;
import java.util.*;

public class Main {
    Vector<Vector<Pair>> v = new Vector<>();
    private boolean[] visited;
    private int V;
    int max = Integer.MIN_VALUE;
    int tmp;

    class Pair{
        int v;
        int dist;

        public Pair(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }

    void dfs(int x, int val){
        if(visited[x]) return;

        boolean flag = false;
        for (var k : v.get(x))
            if(!visited[k.v]) {
                visited[x] = true;
                dfs(k.v, val + k.dist);
                visited[x] = false;
                flag = true;
            }
        if(!flag) {
            if(max < val){
                max = val;
                tmp = x;
            }
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        visited = new boolean[V];

        for(int i = 0 ; i < V; i++){
            v.add(new Vector<>());
        }

        // 정점의 번호가 1번부터 순차적이라고 가정
        for(int i = 0 ; i < V-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            v.get(a-1).add(new Pair(b-1, c));
            v.get(b-1).add(new Pair(a-1, c));
        }

        dfs(0, 0);
        dfs(tmp, 0);
        System.out.println(max);


    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
