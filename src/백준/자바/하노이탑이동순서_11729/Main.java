package 백준.자바.하노이탑이동순서_11729;

import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    static void hanoi(int N, int s, int t, int d){
        count += 1;
        if(N == 1){
            sb.append(s + " " + d + "\n");
            return;
        }

        hanoi(N-1, s, d, t);
        sb.append(s+" " + d +"\n");
        hanoi(N-1, t, s, d);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc .nextInt();
        hanoi(n, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb);


    }
}
