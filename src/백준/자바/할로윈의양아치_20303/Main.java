package 백준.자바.할로윈의양아치_20303;

import java.io.*;
import java.util.*;

public class Main {
    private int N, M, K;
    private int[] values;
    private int[] parents;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        values = new int[N];
        parents = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }


        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            if(find(a) != find(b)) union(a, b);
            //유니온파인드
        }


        for(int i = 0; i < N; i++) {
            if (map.get(find(i)) == null) {
                map.put(find(i), index++);
            }
        }

        int[] weight = new int[index+1];
        int[] candy = new int[index+1];

        for(int i = 0; i < N; i++){
            int val = find(i);
            int pos = map.get(val)+1;

            weight[pos]++;
            candy[pos] += values[i];
        }



        int[][] d = new int[index+1][K];

        for(int i = 1 ; i < index+1; i++){
            for(int j = 1; j < K; j++){
                if(weight[i] > j) {
                    d[i][j] = d[i-1][j];
                }
                else d[i][j] = Math.max(d[i-1][j], d[i-1][j-weight[i]] + candy[i]);
            }
        }

        System.out.println(d[index][K-1]);

    }

    int find(int x){
        if(x == parents[x])
            return x;
        return parents[x] = find(parents[x]);
    }

    void union(int x, int y){
        int a = find(x);
        int b = find(y);

        if(a != b)
            parents[b] = a;
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}

