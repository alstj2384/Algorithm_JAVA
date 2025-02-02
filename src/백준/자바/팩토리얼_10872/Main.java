package 백준.자바.팩토리얼_10872;

import java.util.Scanner;

public class Main {
    static int fac(int x){
        if(x == 1 || x == 0) return 1;
        return x * fac(x-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fac(n));
    }
}
