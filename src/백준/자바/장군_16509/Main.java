package 백준.자바.장군_16509;

import java.io.*;
import java.util.*;

public class Main {
    private int r1, c1;
    private int[][] dx = {{-1, 0, 1, 0}, {-1, -1, 1, 1}, {-2, -2, 2, 2}};
    private int[][] dy = {{0, -1, 0, 1}, {1, -1, -1, 1}, {2, -2, -2, 2}};
    private boolean visited[][];

    Queue<Pair> q = new LinkedList<>();

    int bfs(int r2, int c2) {

        q.add(new Pair(r2, c2, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if(visited[p.x][p.y]) continue;
            visited[p.x][p.y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[0][i];
                int ny = p.y + dy[0][i];
                if (nx < 0 || ny < 0 || nx >= 10 || ny >= 9) continue;
                if (r1 == nx && c1 == ny) {
                    continue;
                }

                for(int a = i; a < i+2; a++){
                    int k = a%4;
                    if (nx + dx[2][k] < 0 || ny+dy[2][k] < 0 || nx+dx[2][k] >= 10 || ny+dy[2][k] >= 9) {
                        continue;
                    }
                    if(!(r1 == nx + dx[1][k] && c1 == ny+ dy[1][k])) {
                        if (r1 == nx + dx[2][k] && c1 == ny + dy[2][k]) {
                            return p.count + 1;
                        }
                        else {
                            if(!visited[nx+dx[2][k]][ny+dy[2][k]]) {
                                q.add(new Pair(nx + dx[2][k], ny + dy[2][k], p.count + 1));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    class Pair{
        int x;
        int y;
        int count;

        public Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new boolean[10][9];

        int r2, c2;
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());

        System.out.println(bfs(r2, c2));

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
