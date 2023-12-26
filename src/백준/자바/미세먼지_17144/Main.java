package 백준.자바.미세먼지_17144;

import java.io.*;
import java.util.*;

// 1시간 40 분 solve
public class Main {
    private int arr[][][];
    private int R, C, T;
    private int main_board = 0; // 현재 사용중인 board

    private int[] dx = {0, -1, 0, 1};
    private int[] dy = {1, 0, -1, 0};
    private int headx, heady, tailx, taily;

    void diffusion(){
        int sub_board = main_board == 0 ? 1 : 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                int count = 0; // 확산 된 칸의 개수를 세기 위한 변수
                if(arr[main_board][i][j] != -1 && arr[main_board][i][j] != 0){
                    double diffusion_amout = Math.floor((double)arr[main_board][i][j]/5);

                    for(int k = 0; k < 4; k++){ // 4가지 방향에 대해서
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx >= 0 && ny >= 0 && nx < R && ny < C && arr[main_board][nx][ny] != -1){
                            arr[sub_board][nx][ny] += diffusion_amout;
                            count++;
                        } // 범위를 벗어나지 않거나, -1이 아닌 칸이라면 확산
                    }
                    arr[sub_board][i][j] += arr[main_board][i][j] - (int)(diffusion_amout*count);
                    arr[main_board][i][j] = 0; // 재사용을 위해 board 초기화
                }
            }
        }
        // 사용 board가 swap 되었으므로 main_board 또한 바꿔줌
        main_board = main_board == 1 ? 0 : 1;

    }
    void exec(int x){
        int curx, cury; // 바람의 현재 위치
        int tmp = 0; int prev = 0; int dir = 0;
        // dir은 현재 진행중인 방향을 표시하기 위한 변수
        // prev는 이전 칸의 값을 저장하는 변수

        int[] index = new int[4];
        // 위쪽 바람과 아래쪽 바람의 방향 순서가 다르기 때문에 하나의 dx, dy 배열을
        // 재사용 하기 위한 index변수

        if(x == 0){ // head
            curx = headx; cury = heady;
            index[0] = 0; index[1] = 1; index[2] = 2; index[3]= 3;
            // 위쪽일 경우 dx의 0,1,2,3 순서로 진행하게됨
        }
        else{ // tail
            curx = tailx; cury = taily;
            index[0] = 0; index[1] = 3; index[2] = 2; index[3]= 1;
            // 아래쪽일 경우 dx의 0,3,2,1 순서로 진행하게됨
        }

        while(true) {
            if (!(curx + dx[index[dir]] >= 0 && curx + dx[index[dir]] < R && cury + dy[index[dir]] >= 0 && cury + dy[index[dir]] < C))
                dir++;
            // 다음 위치 선정 시 범위 밖인 경우, dir ++(방향 바꿈)

            curx = curx + dx[index[dir]];
            cury = cury + dy[index[dir]];

            if(arr[main_board][curx][cury]== -1)
                break;

            prev = arr[main_board][curx][cury];
            arr[main_board][curx][cury] = tmp;
            tmp = prev;
        }
    }


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int sum = 0; // 합계 저장 변수

        arr = new int[2][R][C];

        boolean is_first = true; // 공기청정기 위치 특정을 위한 변수

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[0][i][j] = Integer.parseInt(st.nextToken());
                if(arr[0][i][j] == -1) {
                    arr[1][i][j] = -1;
                    if(is_first) {headx = i; heady = j; is_first = false;}
                    // 첫번째인 경우 위쪽 공기청정기
                    else {tailx = i; taily = j;}
                    // 두번째인 경우 아래 공기청정기
                }
            }
        }

        for(int i = 0; i < T; i++){
            diffusion();
            exec(0); // 위쪽 실행
            exec(1); // 아래쪽 실행
        }

        for(var k : arr[main_board])
            for(var a : k)
                sum += a;

        System.out.println(sum+2);
        // board의 모든 값을 더하고, 공기청정기 칸으로 -2가 된 것을 메꾸기 위해 +2해줌.

    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
