package 백준.자바.피보나치수5_10870;

import java.io.*;
import java.util.*;

public class Main {
    private int[] d;
    int count;

    int dfs(int x){
        count++;
        if(x == 0) return 0;
        if(x == 1) return 1;
        if(d[x] != Integer.MAX_VALUE){
            return d[x];
        }
        return d[x] = (dfs(x-2) + dfs(x-1));
    }
    public void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);

        System.out.println((dfs(n)));


    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}