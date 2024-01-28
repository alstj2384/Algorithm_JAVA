package 백준.자바.문제집_1766;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] entry = new int[N+1];

        List<List<Integer>> arr = new ArrayList<>();

        for(int i = 0; i < N+1; i++)
            arr.add(new ArrayList<>());

        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            entry[b]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 1; i < N+1; i++){
            if(entry[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            int index = q.poll();
            sb.append(index).append(" ");

            for(var k : arr.get(index)){
                entry[k]--;
                if(entry[k] == 0) q.add(k);
            }
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
