package 백준.자바.달팽이리스트_17827;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < M; i++){
            int k = Integer.parseInt(br.readLine());
            if(k >= N) {
                int t;
                if(N == V) t = N-1;
                else t = k%(N-V+1) + (N-V+1) < N ? k%(N-V+1) + (N-V+1) : (k%(N-V+1) + (N-V+1)) % (N-V+1);
                sb.append(arr[t]).append('\n');
            }
            else sb.append(arr[k]).append('\n');
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
