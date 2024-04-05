package 프로그래머스.자바.리코쳇로봇;
import java.util.*;
class Solution {
    static int Rx, Ry, N, M, min = Integer.MAX_VALUE;
    static char[][] map;
    static boolean[][] visited;

    class Pair{
        int x;
        int y;
        int count;
        public Pair(int x, int y, int count){
            this.x =x;
            this.y = y;
            this.count = count;
        }
    }
    Queue<Pair> q = new LinkedList<Pair>();

    void bfs(Pair pq){
        q.offer(pq);
        int hop = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            visited[p.x][p.y] = true;

            for(int i = 0; i < 4; i++){
                Pair rtn = move(p, i);
                if(map[rtn.x][rtn.y] == 'G'){
                    min = Math.min(rtn.count, min);
                    return;
                } else if(visited[rtn.x][rtn.y]){
                    continue;
                } else{
                    q.offer(rtn);
                }
            }
        }
    }


    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    // 하, 상, 우, 좌
    public Pair move(Pair p, int dir){
        int nx = p.x, ny = p.y;
        if(dir == 0){
            // 아래로 가는 경우 (y만 고려하면 됨)
            while(true){
                int nextPos = ny + dy[dir];
                //
                if(nextPos < M && map[nx][nextPos] != 'D'){
                    ny = nextPos;
                } else break;
            }
        }
        else if(dir == 1){
            // 위로 가는 경우
            while(true){
                int nextPos = ny + dy[dir];
                if(nextPos > -1 && map[nx][nextPos] != 'D'){
                    ny = nextPos;
                } else break;
            }
        }
        else if(dir == 2){
            // 오른쪽으로 가는 경우
            while(true){
                int nextPos = nx + dx[dir];
                if(nextPos < N && map[nextPos][ny] != 'D'){
                    nx = nextPos;
                } else break;
            }
        }
        else if(dir == 3){
            while(true){
                int nextPos = nx + dx[dir];
                if(nextPos > -1 && map[nextPos][ny] != 'D'){
                    nx = nextPos;
                } else break;
            }
        }
        return new Pair(nx, ny, p.count+1);
    }
    public int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        map = new char[N][M];

        for(int i = 0; i < board.length; i++){
            String s = board[i];
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(c == 'R'){
                    map[i][j] = '.';
                    Rx = i;
                    Ry = j;
                }
                else map[i][j] = s.charAt(j);
            }
        }

        visited = new boolean[N][M];

        bfs(new Pair(Rx, Ry, 0));
        answer = min == Integer.MAX_VALUE ? -1 : min;
//         for(var k : map){
//             for(var q : k){
//                 System.out.print(q + " ");
//             }
//             System.out.println();

//         }
        return answer;
    }
}