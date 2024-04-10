package 프로그래머스.자바.가장먼노드;
import java.util.*;
class Solution {
    class Node{
        int node;
        int dist;
        public Node(int n, int d){
            node = n;
            dist = d;

        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }

        for(var k : edge){
            graph.get(k[0]).add(k[1]);
            graph.get(k[1]).add(k[0]);
        }

        Queue<Node> q = new LinkedList<>();
        boolean[] visited= new boolean[n+1];

        q.offer(new Node(1, 0));
        visited[1] = true;
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i = 0; i < graph.get(cur.node).size(); i++){
                int curNode = graph.get(cur.node).get(i);
                if(visited[curNode]) continue;
                visited[curNode] = true;

                q.offer(new Node(curNode, cur.dist+1));
                list.add(cur.dist+1);
            }
        }

        Collections.sort(list, Collections.reverseOrder());
        int max = list.get(0);
        for(var k : list){
            if(max != k) break;
            answer += 1;
        }
        return answer;
    }
}