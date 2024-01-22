package 백준.자바.탈출_3055;

import java.io.*;
import java.util.*;

public class Main {
    private int N, M;
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};
    private char[][] arr;
    private boolean[][] visited;
    private Queue<Pair> q = new LinkedList<>();
    private List<Pair> floodZone = new LinkedList<>();
    void flood(){
        int s = floodZone.size();
        for(int i = 0; i < s; i++){
            for(int j = 0; j < 4; j++){
                int nx = floodZone.get(i).x + dx[j];
                int ny = floodZone.get(i).y + dy[j];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(arr[nx][ny] != 'X' && arr[nx][ny] != 'D' && arr[nx][ny] != '*'){
                    arr[nx][ny] = '*';
                    floodZone.add(new Pair(nx, ny, 0));
                }
            }
        }
    }

    int bfs(int x, int y){

        q.offer(new Pair(x, y, 0));
        visited[x][y] = true;

        int turn = -1;
        while(!q.isEmpty()){
            Pair p = q.poll();

            if(turn < p.count) {
                flood();
                turn = p.count;
            }

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(arr[nx][ny] == 'D') return p.count+1;
                if(!visited[nx][ny] && arr[nx][ny] == '.') {
                    q.offer(new Pair(nx, ny, p.count + 1));
                    visited[nx][ny] = true;
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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int x = 0, y= 0;
        arr = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                if (s.charAt(j) == 'S') {
                    arr[i][j] = '.';
                    x = i;
                    y = j;
                } else if (s.charAt(j) == '*'){
                    arr[i][j] = '*';
                    floodZone.add(new Pair(i, j, 0));
                }
                else arr[i][j] = s.charAt(j);
            }
        }

        int result = bfs(x, y);
        System.out.println(result != -1 ? result : "KAKTUS");
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}