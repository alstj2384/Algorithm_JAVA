package 백준.자바.blobnom_24498;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(rd.readLine());
        int[] arr = new int[n];
        int high = 1;
        int tmp = 1;

        var st = new StringTokenizer(rd.readLine());
        int i = 0;
        while(st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        tmp = Math.max(arr[0], arr[n-1]);
        for(i = 1; i < n-1; i++){
            tmp = Math.max(tmp, arr[i] + Math.min(arr[i-1],arr[i+1]));
        }
        System.out.println(tmp);

    }
}
