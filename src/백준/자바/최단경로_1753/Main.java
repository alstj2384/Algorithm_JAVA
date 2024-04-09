package 백준.자바.최단경로_1753;
import java.io.*;
import java.util.*;

public class Main {
    private static int V, E;
    class Node{
        int end;
        int dist;
        public Node(int e, int d){
            end = e;
            dist  = d;
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int K  = Integer.parseInt(br.readLine());


        boolean[] visit = new boolean[V+1];
        int[] result = new int[V+1];
        List<Node>[] edge = new List[V+1];

        for(int i = 1; i <= V; i++){
            edge[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edge[u].add(new Node(v, w));
        }

        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        result[K] = 0;
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(!visit[now.end]) visit[now.end] = true;
            for(int i = 0; i < edge[now.end].size(); i++){
                Node next = edge[now.end].get(i);
                if(!visit[next.end] && now.dist + next.dist < result[next.end]){
                    result[next.end] = now.dist + next.dist;
                    pq.offer(new Node(next.end, result[next.end]));
                }
            }
        }

        for(int i = 1; i < V+1; i++){
            System.out.println(result[i] == Integer.MAX_VALUE ? "INF" : result[i]);
        }



    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
