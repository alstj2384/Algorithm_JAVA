package 백준.자바.퇴사_14501;


import java.io.*;
import java.util.*;

public class Main {
    private int[] T;
    private int[] P;
    private int[] d;
    private int N;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];
        d = new int[N+1];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N+1; i++){
            int tmp = 0;
            int max = 0;
            for(int j = 0; j < i; j++){
                if(T[j]+j == i)
                    d[i] = Math.max(d[i], d[j]+P[j]);
                max = Math.max(d[j], max);
            }
            d[i] = Math.max(max,d[i]);
        }
        Arrays.sort(d);
        System.out.println(d[N]);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
