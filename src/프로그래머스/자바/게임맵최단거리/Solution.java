package 프로그래머스.자바.게임맵최단거리;
import java.util.*;
class Solution {
    class Pair {
        int x;
        int y;
        int dist;
        public Pair(int x, int y, int dist){
            this.x = x;
            this.y =y ;
            this.dist = dist;
        }
    }
    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int N = maps.length;
        int M = maps[0].length;
        // 0,0 -> n-1, m-1;
        boolean[][] visited = new boolean[N][M];


        Queue<Pair> q = new LinkedList<>();

        visited[0][0] = true;
        q.offer(new Pair(0, 0, 1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.x == N-1 && p.y == M-1) answer = p.dist;

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || maps[nx][ny] == 0) continue;
                visited[nx][ny] = true;

                q.offer(new Pair(nx, ny, p.dist+1));
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
