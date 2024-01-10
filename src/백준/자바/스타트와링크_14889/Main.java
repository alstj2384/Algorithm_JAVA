package 백준.자바.스타트와링크_14889;


import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.*;

public class Main {
    private int[] opr1; // 원본이들어갈자리
    private int[] opr2; // 서브
    private int N;
    private int[][] arr;
    private int ans = Integer.MAX_VALUE;
    void dfs(int at, int index){
        if(index == N/2){
            int sum_opr1 = 0;
            int sum_opr2 = 0;
            int tmp = 0;

            for(int i = 0; i < N; i++){
                boolean flag = false;
                for(var k : opr1) {
                    if (i + 1 == k){
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    opr2[tmp++] = i+1;
            }

            for(int i = 0; i < N/2; i++)
                for(int j = i+1; j < N/2; j++)
                    sum_opr1 += arr[opr1[i]][opr1[j]] + arr[opr1[j]][opr1[i]];

            for(int i = 0; i < N/2; i++)
                for(int j = i+1; j < N/2; j++)
                    sum_opr2 += arr[opr2[i]][opr2[j]] + arr[opr2[j]][opr2[i]];

            ans = Math.min(ans, Math.abs(sum_opr1-sum_opr2));
            return;
        }
        for(int i = at+1; i < N; i++){
            opr1[index] = i;
            dfs(i, index+1);
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        opr1 = new int[N/2];
        opr2 = new int[N/2];
        for(int i = 1; i < N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N+1; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        opr1[0] = 1;
        dfs(0, 0);
        System.out.println(ans);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
