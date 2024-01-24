package 프로그래머스.자바.거리두기확인하기;

class Solution {

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    char[][] arr = new char[5][5];
    boolean[][] visited = new boolean[5][5];
    boolean isNotDistancing;

    void dfs(int x, int y, int depth){
        if(isNotDistancing) return;
        if(depth > 1) return;
        visited[x][y] = true;

        for(int i =0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visited[nx][ny]) continue;
            if(arr[nx][ny] == 'O') {
                dfs(nx, ny, depth+1);
            }
            else if(arr[nx][ny] == 'P') isNotDistancing = true;
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int i = 0; i < 5; i++){
            for(int a = 0; a < 5; a++){
                String s = places[i][a];
                for(int b = 0; b < 5; b++){
                    arr[a][b] = s.charAt(b);
                }
            }
            isNotDistancing = false;

            for(int a = 0; a < 5; a++){
                for(int b = 0; b < 5; b++){
                    if(arr[a][b] == 'P' && !isNotDistancing){
                        dfs(a, b, 0);
                    }
                }
                visited = new boolean[5][5];
            }
            if(isNotDistancing) answer[i] = 0;
            else answer[i] = 1;
        }
        return answer;
    }
}