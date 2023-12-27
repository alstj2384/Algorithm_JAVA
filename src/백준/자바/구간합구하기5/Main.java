package 백준.자바.구간합구하기5;

import java.io.*;
import java.util.*;

public class Main {
    // 이 부분에 static으로 사용 할 멤버 선언
    // private int max = 0; ...
    // private int[] arr; ...
    // private void dfs()...
    private int n, m;
    private int[][] arr;
    class point{
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return "("+x+","+y+")";
        }
    }
    class pair{
        point a;
        point b;

        public pair(point a, point b) {
            this.a = a;
            this.b = b;
        }
        public String toString(){
            return a + " "+ b;
        }
    }

    int seq_sum(pair p){
        int sum = 0;
        for(int i = p.a.x-1; i < p.b.x ; i++)
            for(int j = p.a.y-1; j < p.b.y; j++)
                sum += arr[i][j];

        return sum;
    }
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Vector<pair> v = new Vector<>();

        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            v.add(new pair(new point(x1, y1), new point(x2, y2)));
        }

        for(var k : v){
            System.out.println(seq_sum(k));
        }
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}