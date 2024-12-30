package 프로그래머스.자바.부대복귀;

import java.util.*;

class Solution {
    static class Pair{
        int index, count;
        public Pair(int index, int count){
            this.index = index;
            this.count = count;
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < n+1; i++){
            map.add(new ArrayList<>());
        }

        for(int i = 0; i< roads.length; i++){
            map.get(roads[i][0]).add(roads[i][1]);
            map.get(roads[i][1]).add(roads[i][0]);
        }

        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);

        visited[destination] = 0;

        Queue<Pair> q = new LinkedList<Pair>();

        q.offer(new Pair(destination, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();

            List<Integer> curNode = map.get(p.index);
            for(int i = 0; i < curNode.size(); i++){
                int nextNode = curNode.get(i);

                if(visited[nextNode] == -1){
                    q.offer(new Pair(nextNode, p.count+1));
                    visited[nextNode] = p.count + 1;
                }
            }
        }


        for(int i = 0; i < sources.length; i++){
            answer[i] = visited[sources[i]];
        }

        return answer;
    }
}