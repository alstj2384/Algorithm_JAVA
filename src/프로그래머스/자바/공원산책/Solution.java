package 프로그래머스.자바.공원산책;
import java.util.*;
class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] map;
    int x, y, nx, ny, N, M;
    boolean isBlocked;

    void move(int dir, int dist){
        isBlocked=false;
        int i = 0;
        nx = x;
        ny = y;

        while(i < dist){
            nx += dx[dir];
            ny += dy[dir];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 'X') {
                isBlocked = true;
                return;
            }
            i++;
        }
    }
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};

        N = park.length;
        M = park[0].length();
        map = new int[N][M];

        x = 0;
        y = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(park[i].charAt(j) == 'S'){
                    x = i;
                    y = j;
                    map[i][j] = 'O';
                } else map[i][j] = park[i].charAt(j);
            }
        }

        for(var k : routes){
            StringTokenizer st = new StringTokenizer(k);
            String c = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());

            if(c.equals("N")) move(0, dist);
            else if(c.equals("S")) move(1, dist);
            else if(c.equals("W")) move(2, dist);
            else move(3, dist);

            if(!isBlocked){
                x = nx;
                y = ny;
            }
        }
        answer= new int[2];
        answer[0] = x;
        answer[1] = y;

        return answer;
    }
}