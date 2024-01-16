package 백준.자바.RGB거리2_17404;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] RGB = new int[N][3];
        int[][] d = new int[N][3];

        for(int i  =0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3; j++)
                RGB[i][j] = Integer.parseInt(st.nextToken());
        }

        int total = Integer.MAX_VALUE;

        // R, G, B 각각에 대해 한 번씩 반복
        for(int i =0 ; i < 3; i++){
            // i == 0인 경우, R 이외의 G, B는 각각 최댓값 + 1로 초기화
            for(int k = 0; k < 3; k++){
                if(i == k) d[0][k] = RGB[0][k];
                else d[0][k] = 1001;
            }

            // dp
            for(int j = 1; j < N; j++){
                d[j][0] = Math.min(d[j-1][1], d[j-1][2])+RGB[j][0];
                d[j][1] = Math.min(d[j-1][0], d[j-1][2])+RGB[j][1];
                d[j][2] = Math.min(d[j-1][0], d[j-1][1])+RGB[j][2];
            }

            // 처음 고정 시켜놓은 값의 인덱스는 참조가 불가능하므로
            // 해당 인덱스를 제외한 다른 인덱스의 최소값 결정
            int t = Integer.MAX_VALUE;
            for(int k = 0; k < 3; k++){
                if(i==k) continue;
                if(t > d[N-1][k]) t = d[N-1][k];
            }

            // 총 3번의 반복(R, G, B) 중 최소값을 갱신
            total = Math.min(t, total);
        }

        System.out.println(total);


    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
