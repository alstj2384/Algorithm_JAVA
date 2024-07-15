package 백준.자바.꽃길_14620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, ret, result;
    static int[][] map;
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};
    static boolean[][] visited;

    static boolean isPlantable(int x, int y){
        return y >= 0 && x >= 0 && y < N && x < N && !visited[x][y];
    }

    static boolean checkRange(int x, int y){
        return  isPlantable(x + dx[0], y + dy[0]) &&
                isPlantable(x + dx[1], y + dy[1]) &&
                isPlantable(x + dx[2], y + dy[2]) &&
                isPlantable(x + dx[3], y + dy[3]) &&
                isPlantable(x + dx[4], y + dy[4]);
    }

    static int seed(int x, int y){
        int ret = 0;
        for(int i = 0; i < 5; i++) {
            ret += map[x + dx[i]][y + dy[i]];
            visited[x + dx[i]][y + dy[i]] = true;
        }
        return ret;
    }

    static void unSeed(int x, int y){
        for(int i = 0; i < 5; i++) {
            visited[x + dx[i]][y + dy[i]] = false;
        }
    }
    static void plant(int index, int seedCount){
        if(index >= N * N) return;
        if(seedCount == 0) {
            result = Math.min(ret, result);
            return;
        }
        int x = index / N;
        int y = index % N;

        int cost = 0;
        if(checkRange(x, y)){
            cost = seed(x, y);
            ret += cost;
            plant(index + 1, seedCount-1);
            unSeed(x, y);
            ret -= cost;
        }
        plant(index + 1, seedCount);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        result = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ret = 0;
        plant(0, 3);
        System.out.println(result);

    }
}
