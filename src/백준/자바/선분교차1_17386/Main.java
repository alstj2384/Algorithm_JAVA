package 백준.자바.선분교차1_17386;

import java.io.*;
import java.util.*;

public class Main {
    class Pair{
        long x;
        long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Pair p1, p2, p3, p4;

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        p2 = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        p3 = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        p4 = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        System.out.println((ccw(p1, p2, p3) * ccw(p1, p2, p4) <= 0
                && ccw(p3, p4, p1) * ccw(p3, p4, p2) <= 0)?
                1:0);


    }

    private int ccw(Pair p1, Pair p2, Pair p3){
        long s1 = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y;
        long s2 = p1.y * p2.x + p2.y * p3.x + p3.y * p1.x;

        if(s1-s2 > 0) return 1;
        else if(s1-s2 == 0) return 0;
        else return -1;
    }

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
