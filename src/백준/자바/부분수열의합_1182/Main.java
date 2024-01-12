package 백준.자바.부분수열의합_1182;


import java.io.*;
import java.util.*;

public class Main {

    private int[] d;
    private int N, S;
    private int count;

    void dfs(int depth, int sum){
        if(depth == N) {
            if(sum == S) count++;
            return;
        }

        dfs(depth+1, sum+d[depth]);
        dfs(depth+1, sum);
    }


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        d = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) d[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);
        if(S == 0) count--;
        System.out.println(count);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}