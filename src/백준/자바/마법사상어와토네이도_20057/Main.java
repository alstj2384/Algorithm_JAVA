package 백준.자바.마법사상어와토네이도_20057;
import java.io.*;
import java.util.*;

public class Main {
    private int[][] windX = {{1, -1, 2, 1, -1, -2, 1, -1, 0, 0}, {0, 0, 1, 1, 1, 1, 2, 2, 3, 1},
            {1, -1, 2, 1, -1,-2, 1,-1, 0, 0},{0, 0, -1, -1, -1, -1, -2, -2, -3, -1}};
    private int[][] windY = {{0, 0, -1, -1, -1, -1, -2, -2, -3, -1},{1, -1, 2, 1, -1, -2, 1, -1, 0, 0}
            ,{0, 0, 1, 1, 1, 1, 2, 2, 3, 1}, {-1, 1, -2, -1, 1, 2, -1, 1, 0, 0}};
    private double[] rate = {0.01, 0.01, 0.02, 0.07, 0.07, 0.02, 0.1,  0.1, 0.05, 0};
    private int N;
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {-1, 0, 1, 0};
    private int[] ax = {0, 2, 0, -2};
    private int[] ay = {-2, 0, 2, 0};
    private int[][] map;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int x = N/2;
        int y = N/2;

        int dir = 0;// 방향을 가르키는 변수, 좌,하,우,상 순서
        int length = 1; // 현재 해당 방향으로 이동해야하는 총 거리
        int curLength = 0; // 현재 총 거리 중 이동한 칸의 개수
        int turnCount = 0; // 두 번 회전하면 length 길이 증가 필요

        int blowUpSand = 0;

        int count = 0;
        while(true){

            if(x == 0 && y == 0){
                break;
            }
            if(length == curLength){
                // 둘의 길이가 같으면 방향을 바꾸어야함
                dir = (dir+1)%4;
                curLength = 0;
                turnCount++;

                if(turnCount == 2) {
                    // 두 번 회전을 했을 경우, 길이를 늘려주어야 한다.
                    length++;
                    turnCount = 0;
                }
            }
            curLength++;

            int sand = map[x+dx[dir]][y+dy[dir]];
            map[x+dx[dir]][y+dy[dir]] = 0;

            int total = 0;
            for(int i = 0 ;i < 10; i++){
                int nx = x + windX[dir][i];
                int ny = y + windY[dir][i];
                int sandAmount = (int)(rate[i]*sand);
                total += sandAmount;
                if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                    // 밖으로 날아가 버리는 경우
                    blowUpSand += sandAmount;
                    continue;
                }
                map[nx][ny] += sandAmount;
            }

            int nx = x + ax[dir];
            int ny = y + ay[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                // 밖으로 날아가 버리는 경우
                blowUpSand += sand-total;
            }
            else map[nx][ny] += sand-total;


            x += dx[dir];
            y += dy[dir];
        }
        System.out.println(blowUpSand);


    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
