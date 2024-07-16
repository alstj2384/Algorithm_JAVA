package 백준.자바.수열_2559;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class newMain {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] psum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++){
            psum[i] = psum[i-1] + Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N - K + 1 ; i++){
            max = Math.max(max, psum[i+K] - psum[i]);
        }
        System.out.println(max);
    }
}
