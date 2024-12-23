package 백준.자바.지름길_1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static class Pair{
        int start, end, dist;

        public Pair(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] map = new int[D+1];

        Arrays.fill(map, 100_000_000);
        map[0] = 0;
        Pair[] p = new Pair[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            p[i] = new Pair(start, end, dist);
        }
        //TODO 지름길 검사
        for(var s : p){
            if(s.start == 0){
                if(s.end <= D)
                    map[s.end] = Math.min(map[s.end], map[0] + s.dist);
            }
        }


        for(int i = 1; i <= D; i++){
            if(map[i] != 100_000_000){
                map[i] = Math.min(map[i-1]+1, map[i]);
            } else{
                map[i] = map[i-1] + 1;
            }

            //TODO 지름길 검사
            for(var s : p){
                if(s.start == i){
                    if(s.end <= D) {
                        map[s.end] = Math.min(map[s.end], map[i] + s.dist);
                    }
                }
            }

//            for(var q : map){
//                System.out.print(q + " ");
//            }
//            System.out.println();
        }

        System.out.println(map[D]);
    }
}
