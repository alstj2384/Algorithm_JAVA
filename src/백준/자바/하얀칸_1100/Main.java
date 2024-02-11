package 백준.자바.하얀칸_1100;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        for(int i = 1; i < 9; i++){
            String s = br.readLine();
            for(int j = 1; j < 9; j++){
                if(i%2 == 1 && j % 2 == 1) {
                    if (s.charAt(j - 1) == 'F') count++;
                }
                else if(i % 2 == 0 && j % 2 == 0 ) {
                    if(s.charAt(j-1)=='F') count++;
                }
            }
        }
        System.out.println(count);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
