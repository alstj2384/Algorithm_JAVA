package 프로그래머스.자바.석유시추;
import java.util.*;
class Solution {
    // 각 석유 덩어리의 번호와 석유 양이 key, value
    Map<Integer, Integer> map = new HashMap<>();

    // oilNum = 오일 덩어리마다 매기는 수
    // oilAmont = 해당 오일 덩어리의 오일 총 칸의 수
    int oilNum=1, oilAmount, N, M;

    boolean[][] visited;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    void dfs(int x, int y, int[][] land){
        if(visited[x][y]) return;
        visited[x][y] = true;
        if(land[x][y] == 0) return;

        // 해당 칸을 oilNum으로 변경
        land[x][y] = oilNum;
        oilAmount++;

        for(int i =0 ;i < 4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
            dfs(nx, ny, land);
        }

    }
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;

        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                oilAmount = 0;
                dfs(i, j, land);
                if(oilAmount != 0){
                    map.put(oilNum, oilAmount);

                    // 오일을 1칸이라도 발견했으므로 oilNum++
                    oilNum++;
                }
            }
        }

        // 오일 덩어리의 개수만큼 visited 배열 생성
        // 오일 덩어리 중복 계산을 방지하기 위한 visited 배열
        boolean[] visited_col = new boolean[oilNum];
        int max_oil = 0;

        // 한 열을 기준으로 탐색을 시작
        for(int i = 0; i < M; i++){
            Arrays.fill(visited_col, false);

            // 해당 열에서 발견한 오일 덩어리의 크기
            int cur_oil = 0;

            // 해당 열의 모든 행을 탐색한다
            for(int j = 0; j < N; j++){
                int x = land[j][i];

                // 해당 칸이 석유가 있는 땅일 경우(oilNum이 매겨진 땅일 경우)
                // && 해당 오일 덩어리가 같은 열 탐색중 계산하지 않은 덩어리일 경우
                if(x != 0){
                    if(!visited_col[x]){

                        // 해당 오일 덩어리를 방문처리 하고, 해당 칸의 덩어리 개수만큼 cur_oil에 더하기
                        visited_col[x] = true;
                        cur_oil += map.get(x);
                    }
                }
            }
            max_oil = Math.max(cur_oil, max_oil);
        }
        answer = max_oil;
        return answer;
    }
}
