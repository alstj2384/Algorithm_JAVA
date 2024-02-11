package 백준.자바.공항_10775;


import java.io.*;
import java.util.*;

public class Main {
    private int G, P;
    private int[] parent;
    void union(int x, int y){
        int a = find(x);
        int b = find(y);
        if(a != b){
            parent[a] = b;
        }
    }

    int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        //G개만큼 parents만들기

        parent = new int[G+1]; // 0번은 사용하지 않음!!
        for(int i = 0; i < G+1; i++) parent[i] = i;

        int ans = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int emptyGate = find(g);

            if (emptyGate == 0) {
                break;
            }

            ans++;
            union(emptyGate, emptyGate - 1);
        }

        System.out.println(ans);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
