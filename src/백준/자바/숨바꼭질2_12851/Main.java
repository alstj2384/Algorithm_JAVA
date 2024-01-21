package 백준.자바.숨바꼭질2_12851;
import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] visited = new int[100001];

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(n, 0));

        int min = Integer.MAX_VALUE;
        int ways = 0;

        if(n >= m) {
            min = n-m;
            ways = 1;
        }
        else {
            while(!q.isEmpty()){
                Pair p = q.poll();
                if(p.pos < 0 || p.pos > 100000 || p.pos > m+(m-n)) continue;
                if(p.pos == m){
                    if(p.count < min){
                        ways = 1;
                        min = p.count;
                    }
                    else if(p.count==min){
                        ways+=1;
                    }
                }
                if(visited[p.pos] == 0 || visited[p.pos] == p.count) {
                    visited[p.pos] = p.count;
                    q.add(new Pair(p.pos * 2, p.count + 1));
                    q.add(new Pair(p.pos + 1, p.count + 1));
                    q.add(new Pair(p.pos - 1, p.count + 1));
                }



            }
        }
        System.out.println(min);
        System.out.println(ways);

    }
    class Pair{
        int pos;
        int count;
        public Pair(int pos, int count){
            this.pos = pos;
            this.count = count;
        }
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
