package 프로그래머스.자바.단어변환;
import java.util.*;
class Solution {

    boolean isCanChange(String a, String b){
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff += 1;
            }
        }
        return diff == 1;
    }

    class Pair{
        int n;
        int dist;
        public Pair(int n, int dist){
            this.n = n;
            this.dist = dist;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        int N = words.length;
        int[][] graph = new int[N][N];

        for(int i = 0; i < N-1; i++){
            for(int j = i+1; j < N; j++){
                if(isCanChange(words[i], words[j])){
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }

        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++){
            if(isCanChange(begin, words[i])){
                q.offer(new Pair(i, 1));
                visited[i] = true;
            }
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            if(words[p.n].equals(target)) {
                answer = p.dist;
                break;
            }
            for(int i = 0; i < N; i++){
                if(graph[p.n][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(new Pair(i, p.dist+1));
                }
            }
        }

        return answer;
    }
}
