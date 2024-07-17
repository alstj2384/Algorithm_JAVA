package 백준.자바.가장긴증가하는부분수열_11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class newMain {
    static int N;
    static int[] arr;
    static int[] cache;

    static int lis(int start){
        if(cache[start] != -1) return cache[start];

        cache[start] = 1;

        for(int i = start + 1; i < N; i++){
            if(arr[start] < arr[i]){
                cache[start] = Math.max(cache[start], lis(i) + 1);
            }
        }
        return cache[start];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        cache = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(cache, -1);

        int maxLen = 0;
        for(int i = 0; i < N; i++){
            maxLen = Math.max(maxLen, lis(i));
        }
        System.out.println(maxLen);

    }
}
