package 백준.자바.최소스패닝트리_1197;

import java.io.*;
import java.util.*;

public class Main {

    class node implements Comparable<node>{
        int s, e, v;
        public node(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }
        @Override
        public int compareTo(node o){
            return this.v-o.v;
        }
    }

    int[] parent;
    int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA != parentB){
            parent[parentB] = parentA;
        }
    }

    boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        return x==y;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // parent 변수 초기화
        parent = new int[V + 1];
        for(int i = 1; i < V + 1; i++){
            parent[i] = i;
        }

        Queue<node> pq = new PriorityQueue<>();
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new node(a, b, w));
        }

        // 가중치에 맞게 정렬

        int weight = 0;
        for(int i = 0; i < E; i++){
            node n = pq.poll();
            if(!isSameParent(n.s, n.e)){
                weight += n.v;
                union(n.s, n.e);
            }
        }
        System.out.println(weight);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}