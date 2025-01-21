package 백준.자바.가장큰증가하는부분수열_11055;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n+1];

        int[] d = new int[n+1];

        for(int i = 1; i < n+1; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i < n+1; i++){
            int maxD = 0;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    maxD = Math.max(maxD, d[j]);
                }
            }
            d[i] = maxD + arr[i];
        }

        int max = 0;
        for(var p : d){
            max = Math.max(p, max);
        }
        System.out.println(max);
    }
}
