package 백준.자바.수학은비대면강의입니다_19532;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        int a, b, c, d, e, f;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        e = sc.nextInt();
        f = sc.nextInt();
        for(int i = -999; i < 1000; i++)
            for(int j = -999; j < 1000; j++)
                if(a*i + b*j == c && d*i + e*j == f){
                    System.out.println(i + " " + j);
                    break;
                }
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}