package 백준.자바.최소비용구하기_1916;


import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

public class Main {

    StringBuilder sb = new StringBuilder();
    private int V, E, start, end;
    private int[] visit;
    private List<ArrayList<Node>> graph = new ArrayList<>();
    class Node{
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s, e, cost;
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        graph = new ArrayList<ArrayList<Node>>();

        for(int i = 0; i < V+1; i++)
            graph.add(new ArrayList<Node>());


        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int[] dist = new int[V+1];
        visit = new int[V+1];
        for(int i = 0; i < V+1; i++) {
            dist[i] = Integer.MAX_VALUE;
//            visit[i] = i;
        }

        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        q.offer(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            if(curNode.idx ==  end)
                break;

            if(dist[curNode.idx] < curNode.cost) continue;
            for(int i = 0; i < graph.get(curNode.idx).size(); i++){
                Node next = graph.get(curNode.idx).get(i);
                if(dist[next.idx] > curNode.cost+next.cost){
                    dist[next.idx] = curNode.cost+next.cost;
                    visit[next.idx] = curNode.idx;
                    q.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        sb.append(dist[end]);

        System.out.println(sb);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
