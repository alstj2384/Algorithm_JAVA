package 백준.자바.가장긴증가하는부분수열_11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] d = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            d[i] = 1;
        }

        for(int i  = 1; i < n; i++){
            max = 0;
            for(int j = 0; j < i; j++)
                if(arr[j] < arr[i] && d[j] > max) {
                    max = d[j];
                    d[i] = d[j] + 1;
                }
        }
        for(int i = 0; i < n; i++)
            max = Math.max(max, d[i]);

        System.out.println(max);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}