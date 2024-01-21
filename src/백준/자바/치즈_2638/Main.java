package 백준.자바.치즈_2638;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int[][] arr = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        List<Pair> melt = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();

        // 입력 받기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        // 시간 체크 변수
        int count = 0;

        q.add(new Pair(0, 0));
        visited[0][0] = true;

        // BFS
        while(!q.isEmpty()){
            Pair p = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(arr[nx][ny] == 0 && !visited[nx][ny]) {
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
                // 값이 3 이상(인접한 0이 2개 이상)인 경우 melt 리스트 삽입
                else if(arr[nx][ny] >= 1){
                    arr[nx][ny]++;
                    if(arr[nx][ny] >= 3)
                        melt.add(new Pair(nx, ny));
                }
            }

            // 큐가 비었고, 녹을 치즈가 남아있으면 실행
            if(q.isEmpty() && !melt.isEmpty()){
                for(var k : melt){
                    // 각각 녹은 치즈 칸을 0으로 변경 및 큐에 삽입
                    if(!visited[k.x][k.y]) {
                        arr[k.x][k.y] = 0;
                        q.add(new Pair(k.x, k.y));
                        visited[k.x][k.y] = true;
                    }
                }
                count++;
                melt.clear();
            }
        }
        System.out.println(count);
    }
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
