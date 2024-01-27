package 백준.자바.피리부는사나이_16724;

import java.io.*;
import java.util.*;

public class Main {
    private int N, M;
    private char[][] arr;
    private Pair[][] parent;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        parent = new Pair[N][M];

        for(int i = 0; i < N; i++){
//            arr[i] = br.readLine().toCharArray();
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                parent[i][j] = new Pair(i, j);
            }
        }


        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 'D'){
                    Pair pt1 = parent[i][j];
                    Pair pt2 = parent[i+1][j];
                    if(!find(pt1).equals(find(pt2))){
                        union(pt1, pt2);
                    }
                }

                else if(arr[i][j] == 'U'){
                    Pair pt1 = parent[i][j];
                    Pair pt2 = parent[i-1][j];
                    if(!find(pt1).equals(find(pt2))){
                        union(pt1, pt2);
                    }
                }

                else if(arr[i][j] == 'R'){
                    Pair pt1 = parent[i][j];
                    Pair pt2 = parent[i][j+1];
                    if(!find(pt1).equals(find(pt2))){
                        union(pt1, pt2);
                    }
                }

                else if(arr[i][j] == 'L'){
                    Pair pt1 = parent[i][j];
                    Pair pt2 = parent[i][j-1];
                    if(!find(pt1).equals(find(pt2))){
                        union(pt1, pt2);
                    }
                }
            }
        }

        Map<Pair, Boolean> map = new HashMap<>();
        for(var k : parent){
            for(var q : k){
                Pair p = find(q);
                map.putIfAbsent(p, true);
            }
        }
        System.out.println(map.size());

    }
    Pair find(Pair p){
        if(p.equals(parent[p.x][p.y]))
            return p;
        return find(parent[p.x][p.y]);
    }

    void union(Pair p1, Pair p2){
        Pair pa = find(p1);
        Pair pb = find(p2);

        if(!pa.equals(pb))
            parent[pa.x][pa.y] = pb;
    }
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o){
            Pair p = (Pair)o;
            return p.x == x && p.y == y;
        }
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}

