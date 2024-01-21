package 백준.자바.치킨배달_15686;

import java.io.*;
import java.util.*;

public class Main {
    private int N, M, min;
    private ArrayList<Pair> homes = new ArrayList<>();
    private ArrayList<Pair> chickens = new ArrayList<>();
    private int sum = Integer.MAX_VALUE;
    void dfs(int depth, int at, String s){
        if(at > chickens.size()) return;
        if(depth == M){
            int total = 0;
            String[] ss = s.strip().split(" ");
            for (var k : homes) {
                min = Integer.MAX_VALUE;
                for(var q : ss){
                    int x2 = chickens.get(Integer.parseInt(q)).x;
                    int y2 = chickens.get(Integer.parseInt(q)).y;
                    min = Math.min((Math.abs(k.x - x2) + Math.abs(k.y - y2)), min);
                }
                total += min;
            }
            sum = Math.min(sum, total);
        }
        for(int i = at; i < chickens.size(); i++){
            dfs(depth+1, i+1, s+" " +i);
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int k = Integer.parseInt(st.nextToken());
                if(k == 1) homes.add(new Pair(i, j));
                if(k == 2) chickens.add(new Pair(i, j));
            }
        }

        dfs(0, 0, "");
        System.out.println(sum);
    }
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x= x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
