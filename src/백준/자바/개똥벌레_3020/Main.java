package 백준.자바.개똥벌레_3020;

import java.io.*;
import java.util.*;

public class Main {
    private int[] up; // 종유석 담는 배열
    private int[] down; // 석순 담는 배열
    private int N, H;
    private int upIdx, downIdx;
    private int min, min_count;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        up = new int[N/2];
        down = new int[N/2];

        for(int u = 0, d = 0, i = 1; i < N+1; i++){
            if(i % 2 == 0) {
                up[u++] = (H-Integer.parseInt(br.readLine())+1);
            }
            else down[d++] =  Integer.parseInt(br.readLine());
        }

        Arrays.sort(up);
        Arrays.sort(down);

        min = Integer.MAX_VALUE;
        for(int i = 1 ; i < H+1; i++){
            while(upIdx < N/2 && up[upIdx] <= i){
                upIdx++;
            }
            while(downIdx < N/2 && down[downIdx] < i){
                downIdx++;
            }
            int broken = upIdx+(N/2-downIdx);
            if(min > broken){
                min = broken;
                min_count = 1;
            }
            else if(min == broken)
                min_count++;
        }
        System.out.println(min + " " + min_count);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}