package 백준.자바.사이클게임_20040;

import java.io.*;
import java.util.*;

public class Main {
    private int[] parent;
    private int N, M, result;
    int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x < y){
            parent[y] = x;
        }else{
            parent[x] = y;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for(int i = 0; i < N; i++) parent[i] = i;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) == find(b)){
                System.out.println(i+1);
                return;
            }else{
                union(a, b);
            }
        }
        System.out.println(0);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}