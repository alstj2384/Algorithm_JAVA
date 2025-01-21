package 백준.자바.ATM_11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] p = new int[N];

        for(int i = 0; i < N; i++){
            p[i] = sc.nextInt();
        }

        Arrays.sort(p);

        for(int i = 1; i < N; i++){
            p[i] = p[i-1] + p[i];
        }

        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += p[i];
        }
        System.out.println(sum);

    }
}
