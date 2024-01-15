package 백준.자바.톱니바퀴_14891;

import java.io.*;
import java.util.*;

public class Main {

    private int[][] sawWheels;
    private int[] sawIndex;

    // 해당 톱니의 9시 방향 인덱스를 구하는 함수
    int getLeft(int index){
        return (sawIndex[index]+6)%8;
    }

    // 해당 톱니의 3시 방향 인덱스를 구하는 함수
    int getRight(int index){
        return (sawIndex[index]+2)%8;
    }

    // 시계방향 회전 후 12시 방향의 인덱스
    int rotateRight(int index){
        return (sawIndex[index]+7)%8;
    }

    // 반시계방향 회전 후 12시 방향의 인덱스
    int rotateLeft(int index){
        return (sawIndex[index]+1)%8;
    }

    void rightCheck(int i, boolean isRight){
        if(i > 2) return;
        // if 두 톱니의 전극이 다르면 회전
        if(sawWheels[i][getRight(i)] != sawWheels[i+1][getLeft(i+1)]){
            rightCheck(i+1, !isRight);
            sawIndex[i+1] = isRight ?  rotateLeft(i+1) : rotateRight(i+1);
        }
    }

    void leftCheck(int i, boolean isRight){
        if(i<1) return;
        // if 두 톱니의 전극이 다르면 회전
        if(sawWheels[i][getLeft(i)] != sawWheels[i-1][getRight(i-1)]){
            leftCheck(i-1, !isRight);
            sawIndex[i-1] = isRight ?  rotateLeft(i-1) : rotateRight(i-1);
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sawWheels = new int[4][8];
        sawIndex = new int[4];

        for(int i = 0 ; i < 4; i++){
            String s = br.readLine();
            for(int j = 0 ; j <8; j++){
                sawWheels[i][j] = s.charAt(j)-'0';
            }
        }

        int k = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken());

            rightCheck(a, b == 1);
            leftCheck(a, b==1);

            sawIndex[a] = b==1 ?  rotateRight(a) : rotateLeft(a);
        }
        int total = 0;


        if(sawWheels[0][sawIndex[0]] == 1) total += 1;
        if(sawWheels[1][sawIndex[1]] == 1) total += 2;
        if(sawWheels[2][sawIndex[2]] == 1) total += 4;
        if(sawWheels[3][sawIndex[3]] == 1) total += 8;

        System.out.println(total);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
