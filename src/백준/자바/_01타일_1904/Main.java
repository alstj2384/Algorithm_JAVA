package 백준.자바._01타일_1904;

import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        d[1] = 1;
        if(n > 1) d[2] = 2;

        for(int i = 3; i < n+1; i++){
            d[i] = (d[i-2] + d[i-1])%15746;
        }
        System.out.println(d[n]);

    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
