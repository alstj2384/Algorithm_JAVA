package 백준.자바.순열사이클_10451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Integer[] parent;
    static int find(int x){
        if(parent[x] != x)
            return parent[x] = find(parent[x]);
        return x;
    }

    static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x > y){
            parent[x] = y;
        } else
            parent[y] = x;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            parent = new Integer[N+1];
            // parent 배열 초기화
            for(int i = 0; i < N+1; i++) parent[i] = i;

            StringTokenizer s = new StringTokenizer(br.readLine());

            for(int i = 1; i <= N; i++){
                int k = Integer.parseInt(s.nextToken());
                union(i, k);
            }
            for(int i = 1; i < N+1; i++){
                find(i);
            }

            Set<Integer> set = new HashSet<>(Arrays.asList(parent));
            System.out.println(set.size()-1);
        }
    }
}
