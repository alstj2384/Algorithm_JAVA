package 백준.자바.별찍기8_2445;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++) System.out.print("*");
            for(int j = n-i; j > 0; j--) System.out.print(" ");
            for(int j = n-i; j > 0; j--) System.out.print(" ");
            for(int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }

        for(int i = n-1; i > 0; i--){
            for(int j = 0; j < i; j++) System.out.print("*");
            for(int j = 0; j < n-i; j++) System.out.print(" ");
            for(int j = 0; j < n-i; j++) System.out.print(" ");
            for(int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }
    }
}
