package 백준.자바.팩토리얼2_27433;

import java.io.*;
import java.util.*;

public class Main {

    long factorial(int x){
        if(x == 0) return 1;
        return x * factorial(x-1);
    }
    public void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(factorial(n));

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
