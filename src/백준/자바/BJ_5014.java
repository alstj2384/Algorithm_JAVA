package 백준.자바;

import java.util.*;

public class BJ_5014 {
    static Scanner sc = new Scanner(System.in);

    static class Pair{
        int s, c;
        public Pair(int s, int c){
            this.s = s;
            this.c = c;
        }
    }
    static int f, s, g, u, d;
    static boolean[] visited;

    public static void main(String[] args) {
        f = sc.nextInt();
        s = sc.nextInt();
        g = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();

        Queue<Pair> p = new LinkedList<>();
        Vector<Integer> v = new Vector<>();

        visited = new boolean[f+1];
        int[] dx = {u, -d};

        p.add(new Pair(s, 0));
        while(!p.isEmpty()){
            Pair a = p.poll();
            if(a.s == g) {
                v.add(a.c);
                continue;
            }
            for(int i = 0; i < 2; i++){
                int k = a.s + dx[i];

                if(k > 0 & k <= f && !visited[k]){
                    visited[k] = true;
                    p.add(new Pair(k, a.c+1));
                }
            }
        }
        System.out.println(v.isEmpty() ? "use the stairs" : Collections.min(v));
    }
}

