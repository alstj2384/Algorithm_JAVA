package 백준.자바.최소스패닝트리_1197;
import java.io.*;
import java.util.*;

public class Main {
    class Node{
        int u;
        int v;
        int w;
        public Node(int u , int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    int[] parent;

    private int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
    }

    public void solution() throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Node> graph = new ArrayList<>();

        parent = new int[V+1];
        for(int i = 0; i < V+1; i++) parent[i] = i;

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Node(a, b, c));
        }

        Collections.sort(graph, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w - o2.w;
            }
        });

        int weight = 0;
        for(int i = 0; i < graph.size(); i++){
            Node next = graph.get(i);
            if(find(next.u) != find(next.v)){
                union(next.u, next.v);
                weight += next.w;
            }
        }

        System.out.println(weight);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
