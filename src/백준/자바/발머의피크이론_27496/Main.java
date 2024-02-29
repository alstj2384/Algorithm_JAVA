package 백준.자바.발머의피크이론_27496;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] d = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N+1; i++){
            d[i] = d[i-1] + Integer.parseInt(st.nextToken());
        }


        int count = 0;
        int left = 0;
        int right = 1;
        while(right <= N){
            int val = d[right] - d[left];
            if(129 <= val && 138 >= val){
                count+=1;
            }
            if(right - left < L){
                right++;
            }
            else if(right- left == L){
                right++;
                left++;
            }
        }
        System.out.println(count);


    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}

