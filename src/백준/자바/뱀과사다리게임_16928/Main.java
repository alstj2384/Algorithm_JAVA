package 백준.자바.뱀과사다리게임_16928;

import java.io.*;
import java.util.*;

public class Main {

    class Pair{
        int index;
        int count;

        public Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    private Queue<Pair> q = new LinkedList<>();
    private boolean[] visited = new boolean[101];
    private int[] jump = new int[101];
    int bfs(){

        q.add(new Pair(1, 0));
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Pair p = q.poll();

            if(p.index == 100) {
                min = Math.min(min, p.count);
                continue;
            }
            p.index = jump[p.index];
            if(!visited[p.index]) {
                visited[p.index] = true;
                for (int i = 1; i < 7; i++) {
                    if(p.index+i <= 100)
                        q.add(new Pair(p.index+i, p.count+1));
                }
            }
        }
        return min;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 101; i++) jump[i] = i;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n+m; i++){
            st = new StringTokenizer(br.readLine());
            jump[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
