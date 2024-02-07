package 백준.자바.광고_1305;

import java.io.*;
import java.util.*;

public class Main {

    int getPi(String s){
        int j = 0;
        int[] pi = new int[s.length()];

        for(int i = 1; i < s.length(); i++){
            if(j > 0 && s.charAt(i) != s.charAt(j)){
                j = pi[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                pi[i] = ++j;
            }
        }
        return pi[s.length()-1];
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int min = getPi(s);

        System.out.println(L-min);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
