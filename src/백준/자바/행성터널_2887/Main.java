package 백준.자바.행성터널_2887;

import java.io.*;
import java.util.*;

public class Main {
    private int[] parent;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] planet = new int[N][4];
        parent = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            planet[i] = new int[]{a, b, c, i};
            parent[i] = i;
        }

        List<Edges> edges = new ArrayList<>();

        Arrays.sort(planet, (p1, p2) -> p1[0]-p2[0]);
        for(int i = 0; i < N-1; i++)
            edges.add(new Edges(planet[i][3], planet[i+1][3], planet[i+1][0] - planet[i][0]));

        Arrays.sort(planet, (p1, p2) -> p1[1]-p2[1]);
        for(int i = 0; i < N-1; i++)
            edges.add(new Edges(planet[i][3], planet[i+1][3], planet[i+1][1] - planet[i][1]));

        Arrays.sort(planet, (p1, p2) -> p1[2]-p2[2]);
        for(int i = 0; i < N-1; i++)
            edges.add(new Edges(planet[i][3], planet[i+1][3], planet[i+1][2] - planet[i][2]));


        Collections.sort(edges, new Comparator<Edges>() {
            @Override
            public int compare(Edges o1, Edges o2) {
                return o1.dist - o2.dist;
            }
        });


        int total = 0;

        for(int i = 0; i < edges.size(); i++){
            Edges edge = edges.get(i);
            if(find(edge.s) != find(edge.e)){
                total += edge.dist;
                union(edge.s, edge.e);
            }
        }
        System.out.println(total);


        br.close();
    }

    private int find(int x){
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a != b)
            parent[b] = a;
    }

    class Edges{
        int s;
        int e;
        int dist;
        public Edges(int s, int e, int dist){
            this.s = s;
            this.e = e;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}