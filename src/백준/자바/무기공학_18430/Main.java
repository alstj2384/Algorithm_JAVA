package 백준.자바.무기공학_18430;

import java.io.*;
import java.util.*;

public class Main {
    private int n, m;
    private int[][] arr;
    private boolean[][] visited;
    private int[] dx = {-1, 0, 1, 0}; // 상, 좌, 하, 우

    private int[] dy = {0, -1, 0, 1};
    private Vector<Integer> v = new Vector<>();

    private void dfs(int x, int y, int cnt){
        if(y == m) {
            if(x == n-1) {
                v.add(cnt);
                return;
            }
        } // 종료 조건 확인
        if(y == m) {
            x++;
            y = 0; // 좌표 보정
        }
        if(visited[x][y])
            dfs(x, y+1, cnt);
        else{
            //고르는 경우
            for(int i = 0; i < 4; i++){
                int nx1 = x + dx[i];
                int ny1 = y + dy[i];

                int nx2 = x + dx[(i+1)%4];
                int ny2 = y + dy[(i+1)%4];

                if(nx1 < n && ny1 < m && nx1 >= 0 && ny1 >= 0){
                    if(nx2 < n && ny2 < m && nx2 >= 0 && ny2 >= 0){
                        if(!visited[nx1][ny1] && !visited[nx2][ny2]) {
                            visited[nx1][ny1] = true;
                            visited[nx2][ny2] = true;
                            visited[x][y] = true;
                            dfs(x, y + 1, cnt + arr[x][y] * 2 + arr[nx1][ny1] + arr[nx2][ny2]);
                            visited[nx1][ny1] = false;
                            visited[nx2][ny2] = false;
                            visited[x][y] = false;
                        }
                    }
                }
            }
            dfs(x, y+1, cnt);


        }
    }
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0);
        System.out.println(Collections.max(v));
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
