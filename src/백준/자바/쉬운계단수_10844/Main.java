package 백준.자바.쉬운계단수_10844;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[][] d = new long[10][101];

        for(int i = 1 ;i < 10; i++){
            d[i][1] = 1;
        }

        for(int i = 2; i < 101; i++){
            for(int j = 0; j < 10; j++){
                if(j == 0) d[j][i] = d[1][i-1];
                else if(j == 9) d[j][i] = d[8][i-1];
                else d[j][i] = (d[j-1][i-1] + d[j+1][i-1]) % 1000000000;
//                else d[j][i] = (d[j-1][i-1] + d[j+1][i-1]) ;
            }
        }

        long sum = 0L;
//        for(int j = 1; j <= 40; j++) {
            for (int i = 0; i < 10; i++) {
                sum = (sum + d[i][n]) % 1000000000;
            }
//        }

        System.out.println(sum);
    }
}
