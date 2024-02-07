package 백준.자바.우주신과의교감_1774;

import java.io.*;
import java.util.*;

public class Main {
    private int N, M;
    private int[] parent;
    void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x != y){
            parent[y] = x;
        }
    }

    int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    class Edge{
        int start;
        int end;
        double dist;

        public Edge(int start, int end, double dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

    }
    class coor {
        int x;
        int y;
        int index;

        public coor(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<coor> list = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        parent = new int[N+1];
        for(int i = 1; i < N+1; i++) parent[i] = i;

        for(int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new coor(x, y, i));
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                double a = Math.pow(Math.abs(list.get(i).x-list.get(j).x), 2);
                double b = Math.pow(Math.abs(list.get(i).y-list.get(j).y), 2);
                double dist = Math.sqrt(a+b);
                edges.add(new Edge(list.get(i).index, list.get(j).index, dist));
            }
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Double.compare(o1.dist, o2.dist);
            }
        });

        double total = 0;

        for(int i = 0; i < edges.size(); i++){
            int x = edges.get(i).start;
            int y = edges.get(i).end;
            if(find(x) != find(y)){
                union(x, y);
                total += edges.get(i).dist;
            }
        }
        System.out.printf("%.2f", total);






    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
