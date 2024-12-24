package 백준.자바.연속합2_13398;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];
        int[] d = new int[n+1];
        int[] c = new int[n+1];

        Arrays.fill(d, -987654321);
        Arrays.fill(c, -987654321);
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        d[1] = arr[1];

        for(int i = 2; i <= n; i++){
            d[i] = Math.max(d[i-1] + arr[i], arr[i]);
            c[i] = Math.max(c[i-1], d[i-2]) + arr[i];
        }

//        for(var p : d){
//            System.out.print(p + " ");
//        }
//        System.out.println();
//
//        for(var p : c){
//            System.out.print(p + " ");
//        }
        Arrays.sort(d);
        Arrays.sort(c);

//        System.out.println();
        System.out.println(Math.max(d[n], c[n]));
    }
}
