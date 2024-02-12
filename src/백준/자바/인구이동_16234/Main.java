package 백준.자바.인구이동_16234;
import java.io.*;
import java.util.*;

public class Main {
    private int N, L, R, nx, ny, total, country;
    private int[][] map;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private boolean[][] visited;
    private List<Pair> list;

    class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private void dfs(int x, int y){
        list.add(new Pair(x, y));
        visited[x][y] = true;
        total += map[x][y];
        country++;
        for(int i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(check(x,y, nx, ny) && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }

        /**
         * visited[nx][ny] = false;
         * 오류의 소지가 있음
         */
    }

    private boolean check(int x, int y, int nx, int ny){
        int diff = Math.abs(map[nx][ny]-map[x][y]);
        return diff >= L && diff <= R;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while(true) {
            int opened = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        opened++;
                        total = 0;
                        country = 0;
                        list = new ArrayList<>();
                        dfs(i, j);

                        int population = total / country;
                        for (Pair p : list) {
                            map[p.x][p.y] = population;
                        }
                    }
                }
            }
            if(opened == N*N){
                break;
            }

            days++;
        }
        System.out.println(days);




    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
