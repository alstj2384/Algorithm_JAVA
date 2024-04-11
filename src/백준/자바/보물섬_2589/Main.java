package 백준.자바.보물섬_2589;
import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static boolean[][] visited;
    private char[][] map;
    class Pair{
        int x;
        int y;
        int dist;
        public Pair(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    int bfs(int x, int y){
        if(map[x][y] == 'W') return 0;
        Queue<Pair> q = new LinkedList<>();
        visited = new boolean[N][M];
        int max = Integer.MIN_VALUE;

        visited[x][y] = true;
        q.offer(new Pair(x, y, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            max = Math.max(max, p.dist);

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 'W') continue;
                visited[nx][ny] = true;
                q.offer(new Pair(nx, ny, p.dist+1));
            }

        }
        return max;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = s.charAt(j);
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i = 0;  i < N; i++){
            for(int j = 0; j < M; j++){
                result = Math.max(bfs(i, j), result);
            }
        }

        System.out.println(result);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}