package SWEA.보급로_1249;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static class Pair{
        int x;
        int y;
        int value;

        public Pair(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] map = new int[N][N];

            for(int i = 0; i < N; i++){
                String s = sc.next();
                for(int j = 0; j < N; j++){
                    map[i][j] = s.charAt(j)-'0';
                }
            }

            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(0, 0, 0));

            int[][] d = new int[N][N];
            for(int i = 0; i < N ; i++) Arrays.fill(d[i], Integer.MAX_VALUE);

            while(!q.isEmpty()){
                Pair p = q.poll();

                for(int i = 0; i < 4; i++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    int nextCost = p.value + map[nx][ny];
                    if(nextCost >= d[nx][ny]) continue;
                    d[nx][ny] = nextCost;
                    q.offer(new Pair(nx, ny, nextCost));
                }
            }
            System.out.println("#"+test_case+" " + d[N-1][N-1]);
        }
    }
}