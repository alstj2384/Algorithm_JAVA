package 백준.자바.오르막수_11057;

import java.util.Arrays;
import java.util.Scanner;

public class newMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[][] d= new long[10][1001];

        for(int i = 0; i < 10; i++) d[i][0] = 1;

        int n = sc.nextInt();
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 10; j++){
                long sum = 0;
                for(int k = j; k < 10; k++){
                    sum = (sum + d[k][i-1]) % 10_007;
                }
                d[j][i] = sum;
            }
        }

        long sum = 0;
        for(int j = 0; j < 10; j++)
            sum = (sum + d[j][n-1]) % 10_007;

        System.out.println(sum);





    }
}
