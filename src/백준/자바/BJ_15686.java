package 백준.자바;

import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class BJ_15686 {
    static class Pair{
        public int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return x + " " + y;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Vector<Pair> v1 = new Vector<Pair>();
        Vector<Pair> v2 = new Vector<Pair>();

        for(int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n+1; j++){
                String s = st.nextToken();
                if(s.equals("1")){
                    v1.add(new Pair(i, j));
                }
                else if(s.equals("2")){
                    v2.add(new Pair(i, j));
                }

            }
        }
        int[][] dist = new int[v1.size()][v2.size()];
        int z = 0;
        for(var k : v1){
            int idx = 0;
            for(var p : v2){
                dist[z][idx] = Math.abs(p.x - k.x) + Math.abs(p.y - k.y);
                idx++;
            }
            z++;
        }
        int sum;
//        for(var k : dist){
//            Collections.min(k);
//            for(var j : k){
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }
    }
}
