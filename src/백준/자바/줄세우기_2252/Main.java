package 백준.자바.줄세우기_2252;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] entryCount = new int[N+1];

        for(int i = 0; i < N+1; i++) arr.add(new ArrayList<>());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(!arr.get(a).contains(b)) {
                arr.get(a).add(b);
                entryCount[b]++;
            }
        }

        // 위상 정렬을 위한 큐
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < N+1; i++)
            if(entryCount[i] == 0)
                q.offer(i);

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int index = q.poll();
            sb.append(index).append(" ");
            for(int i = 0; i < arr.get(index).size(); i++){
                int next = arr.get(index).get(i);
                entryCount[next]--;
                if(entryCount[next] == 0) q.offer(next);
            }
        }

        System.out.println(sb);
        br.close();
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
