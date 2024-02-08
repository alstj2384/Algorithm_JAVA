package 백준.자바.네트워크연결_1922;


import java.io.*;
import java.util.*;

public class Main {
    class Node{
        int s;
        int e;
        int dist;

        public Node(int s, int e, int dist) {
            this.s = s;
            this.e = e;
            this.dist = dist;
        }
    }

    private int[] parent;
    void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x != y){
            parent[y]= x;
        }
    }

    int find(int x){
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node> edges = new ArrayList<>();
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Node(a, b, c));
        }

        parent = new int[N+1];
        for(int i = 0; i < N+1; i++)
            parent[i] = i;

        Collections.sort(edges, (o1, o2)-> Integer.compare(o1.dist, o2.dist));


        int cost = 0;
        for(int i = 0; i < edges.size(); i++){
            Node curNode = edges.get(i);
            if(find(curNode.s) != find(curNode.e)) {
                union(curNode.s, curNode.e);
                cost += curNode.dist;
            }
        }

        System.out.println(cost);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
