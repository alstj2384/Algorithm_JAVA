package 백준.자바.숫자카드2_10816;


import java.io.*;
import java.util.*;

public class Main {

    int lowerBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] >= key){
                hi = mid;
            } else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    int upperBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] > key){
                hi = mid;
            } else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for(int i =0; i < M; i++) {
            int a = Integer.parseInt(st.nextToken());

            sb.append(upperBound(arr, a) - lowerBound(arr, a)).append(' ');
        }
        System.out.println(sb);


    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
