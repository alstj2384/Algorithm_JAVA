package 백준.자바.벽부수고이동하기4_16946;

import java.io.*;
import java.util.*;

public class Main {
    private boolean[][] visited;
    private int N, M, indexNum;
    private int[][] map;
    private int[][] emptyCount;
    private int[] spaceCount;
    private int count;
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};

    private void dfs(int x, int y){
        visited[x][y] = true;
        count++;
        emptyCount[x][y] = indexNum;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
            if(visited[nx][ny] || map[nx][ny] == 1) continue;
            dfs(nx, ny);
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        emptyCount = new int[N][M];
        visited = new boolean[N][M];
        spaceCount = new int[N * M+1];


        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    indexNum++;
                    count = 0;
                    dfs(i, j);
                    spaceCount[indexNum] = count;
                }
            }
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int[] lst = new int[4];
                    int sum = 0;
                    boolean flag = false;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if(map[nx][ny] == 1) continue;
                        for (int q = 0; q < k; q++) {
                            if (lst[q] == emptyCount[nx][ny]) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            flag = false;
                            continue;
                        }
                        lst[k] = emptyCount[nx][ny];
                        sum += spaceCount[emptyCount[nx][ny]];
                    }
                    sb.append((sum + 1) % 10);
                } else sb.append(0);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
