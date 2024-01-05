package 백준.자바.N과M_4;

import java.io.*;
import java.util.*;

public class Main {
    private int n;
    private int m;
    private int[] arr;
    private static StringBuilder sb = new StringBuilder();
    void dfs(int at, int count) {
        if (count == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = at; i <= n; i++) {
            arr[count] = i;
            dfs(i, count + 1);
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정적변수 N과 M을 초기화해준다.
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs( 1, 0);
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
