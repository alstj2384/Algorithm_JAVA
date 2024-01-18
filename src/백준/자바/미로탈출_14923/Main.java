package 백준.자바.미로탈출_14923;

import java.io.*;
import java.util.*;

public class Main {
    private int N, M, Hx, Hy, Ex, Ey;
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private int[][] arr;

    class Pair{
        int x;
        int y;
        int count;
        boolean isBroken;

        public Pair(int x, int y, int count, boolean isBroken) {
            this.x=  x;
            this.y=  y;
            this.count = count;
            this.isBroken = isBroken;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];


        st = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(st.nextToken())-1;
        Hy = Integer.parseInt(st.nextToken())-1;


        st = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(st.nextToken())-1;
        Ey = Integer.parseInt(st.nextToken())-1;

        // arr 입력받기
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(Hx, Hy, 0, false));

        boolean[][][] visited = new boolean[2][N][M];
        visited[0][Hx][Hy] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for(int i = 0 ; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx == Ex && ny == Ey){
                    System.out.println(p.count+1);
                    return;
                }
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(!p.isBroken){
                    if(!visited[0][nx][ny]) {
                        if (arr[nx][ny] == 1) {
                            q.offer(new Pair(nx, ny, p.count + 1, true));
                            visited[1][nx][ny] = true;
                        } else {
                            q.offer(new Pair(nx, ny, p.count + 1, false));
                            visited[0][nx][ny] = true;
                        }
                    }
                }
                else{
                    if(arr[nx][ny] == 0 && !visited[1][nx][ny]) {
                        q.offer(new Pair(nx, ny, p.count + 1, true));
                        visited[1][nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(-1);


    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}