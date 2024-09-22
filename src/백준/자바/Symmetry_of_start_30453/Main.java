package 백준.자바.Symmetry_of_start_30453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair{
        double x;
        double y;

        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair)obj;
            return p.x == x && p.y == y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }
    static int N;
    static Map<Integer, Pair> coord = new HashMap<>();
    static Map<Pair, Integer> val = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            coord.put(i, new Pair(x, y));
        }

        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                Pair p1 = coord.get(i);
                Pair p2 = coord.get(j);

                double px = (p1.x + p2.x) / 2;
                double py = (p1.y + p2.y) / 2;

                Pair p3 = new Pair(px, py);

                if(i == j){
                    if(!val.containsKey(p3)) {
                        val.put(p3, 1);
                    } else{
                        val.put(p3, val.get(p3)+1);
                    }
                }
                else {
                    if (!val.containsKey(p3)) {
                        val.put(p3, 2);
                    } else {
                        val.put(p3, val.get(p3) + 2);
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (Integer value : val.values()) {
            max = Math.max(value, max);
        }

        System.out.println(max);
    }
}
