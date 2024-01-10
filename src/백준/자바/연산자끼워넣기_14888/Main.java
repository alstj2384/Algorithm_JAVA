package 백준.자바.연산자끼워넣기_14888;

import java.io.*;
import java.util.*;

public class Main {
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    private int[] op;
    private int[] arr;

    void dfs(int val, int depth){
        if(op[0] == 0 && op[1] == 0 && op[2] == 0 && op[3] == 0){
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        // 덧셈, 뺄셈, 곱셈, 나눗셈 순서
        if(op[0] > 0){
            op[0]--;
            dfs(val + arr[depth+1], depth+1);
            op[0]++;
        }
        if(op[1] > 0){
            op[1]--;
            dfs(val - arr[depth+1], depth+1);
            op[1]++;
        }
        if(op[2] > 0){
            op[2]--;
            dfs(val * arr[depth+1], depth+1);
            op[2]++;
        }
        if(op[3] > 0){
            op[3]--;
            dfs(val / arr[depth+1], depth+1);
            op[3]++;
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        op = new int[4];
        for(int i = 0; i < 4; i++)
            op[i] = Integer.parseInt(st.nextToken());

        dfs(arr[0], 0);
        System.out.println(max);
        System.out.println(min);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
