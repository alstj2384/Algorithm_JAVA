package 백준.자바.수찾기_1920;

import java.io.*;
import java.util.*;

public class Main {
    private int[] arr;

    int binarySearch(int key){
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi){
            int mid = (hi+lo)/2;
            if(key > arr[mid]) lo = mid+1;
            else if(key < arr[mid]) hi = mid-1;
            else return mid;
        }
        return -1;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++)
            if(binarySearch(Integer.parseInt(st.nextToken())) >= 0)
                sb.append(1).append('\n');
            else sb.append(0).append('\n');

        System.out.println(sb);
        }





    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}