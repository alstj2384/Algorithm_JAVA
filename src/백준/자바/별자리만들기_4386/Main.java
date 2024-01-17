package 백준.자바.별자리만들기_4386;

import java.io.*;
import java.util.*;

public class Main {
    private Vector<Pair> v = new Vector<>();
    private Vector<Node> N = new Vector<>();
    private int[] parent;

    void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x < y){
            parent[y] = x;
        }
        else{
            parent[x] = y;
        }
    }

    int find(int x){
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    class Node implements Comparable<Node>{
        int x;
        int y;
        double dist;
        public Node(int x, int y, double dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node n){
            if(dist > n.dist) return 1;
            return -1;
        }
    }

    class Pair{
        double x;
        double y;
        public Pair(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double total = 0;

        parent = new int[n];
        for(int i = 0 ;i < n ; i++) parent[i] = i;

        for(int i = 0 ; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());

            v.add(new Pair(a, b));
        }

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                double Line1 = Math.pow(Math.abs(v.get(i).x - v.get(j).x),2);
                double Line2 = Math.pow(Math.abs(v.get(i).y - v.get(j).y), 2);
                N.add(new Node(i, j, Math.sqrt(Line1 + Line2)));
            }
        }

        Collections.sort(N);



        // 크루스칼 수행
        for(int i = 0; i < N.size(); i++){
            int a = N.get(i).x;
            int b = N.get(i).y;
            if(find(a) != find(b)){
                total += N.get(i).dist;
                union(a, b);
            }
        }

        System.out.printf("%.2f", total);

        br.close();
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
