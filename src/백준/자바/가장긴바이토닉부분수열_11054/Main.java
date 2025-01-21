package 백준.자바.가장긴바이토닉부분수열_11054;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        int[] asc = new int[n];
        int[] desc = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        // 왼쪽 -> 오른쪽 가장 긴 증가하는 부분수열 구하기
        asc[0] = 1;
        for(int i = 1; i < n; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]) max = Math.max(max, asc[j]);
            }
            asc[i] = max + 1;
        }


        // 오른쪽 -> 왼쪽 가장 긴 증가하는 부분수열 구하기
        desc[0] = 1;
        for(int i = n-1; i >= 0; i--){
            int max = 0;
            for(int j = n-1; j > i; j--){
                if(arr[i] > arr[j]) max = Math.max(max, desc[j]);
            }
            desc[i] = max + 1;
        }

//        for(var p : asc){
//            System.out.print(p + " ");
//        }
//        System.out.println();
//
//        for(var p : desc){
//            System.out.print(p + " ");
//        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(asc[i] + desc[i]-1, max);
        }
        System.out.println(max);
    }
}
