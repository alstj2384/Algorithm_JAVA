package 백준.자바.벌집_2292;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int interval = 0;
        int cur = 1;
        int count = 1;
        while(cur < N){
            interval += 6;
            cur += interval;
            count++;
        }
        System.out.println(count);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
