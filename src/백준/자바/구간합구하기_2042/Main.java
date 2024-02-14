package 백준.자바.구간합구하기_2042;


import java.io.*;
import java.util.*;

public class Main {
    private int N, M, K;
    private long[] arr, tree;

    private long prefix_sum(int i){
        long result = 0;
        while(i > 0){
            result += tree[i];
            i -= (i& -i);
        }
        return result;
    }

    private void update(int i, long dif){
        while(i <= N){
            tree[i] += dif;
            i += (i & -i);
        }
    }

    private long interval_sum(int start, int end){
        return prefix_sum(end) - prefix_sum(start-1);
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        tree = new long[N+1];
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < N+1; i++){
            long x = Long.parseLong(br.readLine());
            arr[i] = x;
            update(i, x);
        }

        for(int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if(a == 1){
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                long dif = c - arr[b];
                update(b, dif);
                arr[b] = c;
            }
            else if(a == 2){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(interval_sum(b, c)).append('\n');
            }
        }

        System.out.print(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
