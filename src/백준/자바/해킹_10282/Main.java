package 백준.자바.해킹_10282;

import java.io.*;
import java.util.*;

public class Main {
    private int V, E, C;
    private List<List<Pair>> arr;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < T; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            // init
            arr = new ArrayList<>();
            boolean[] visited = new boolean[V+1];
            int[] dist = new int[V+1];
            int start = C;

            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;
            for(int i = 0; i < V+1; i++)
                arr.add(new ArrayList<>());
            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                // 방향은 b -> a
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                arr.get(b).add(new Pair(a, s));
            }

            for(int i = 0; i < V; i++){
                int nodeValue = Integer.MAX_VALUE;
                int nodeIdx = 0;

                for(int j = 1; j < V+1; j++){
                    if(!visited[j]&&dist[j] < nodeValue){
                        nodeValue = dist[j];
                        nodeIdx = j;
                    }
                }
                visited[nodeIdx] = true;
                for(int j = 0; j < arr.get(nodeIdx).size(); j++){
                    Pair p = arr.get(nodeIdx).get(j);
                    if(dist[p.dest] > dist[nodeIdx] + p.dist){
                        dist[p.dest] = dist[nodeIdx] + p.dist;
                    }
                }
            }
            Arrays.sort(dist);
            int count = 0;
            int maxDist = 0;
            for (int i : dist) {
                if(i == Integer.MAX_VALUE) break;
                count++;
                maxDist = i;
            }
            sb.append(count).append(" ").append(maxDist).append('\n');
        }
        System.out.print(sb);


    }
    class Pair{
        int dest;
        int dist;

        public Pair(int dest, int dist) {
            this.dest = dest;
            this.dist = dist;
        }
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
