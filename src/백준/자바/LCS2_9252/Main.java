package 백준.자바.LCS2_9252;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] d = new int[s1.length()+1][s2.length()+1];

        for(int i  = 1; i < s1.length()+1; i++){
            for(int j = 1; j < s2.length()+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    d[i][j] = d[i-1][j-1] + 1;
                } else{
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = s1.length() , j = s2.length();
        while(i > 0 && j > 0){
            if(i == 0 || j == 0) break;
            else if(d[i][j] == d[i-1][j]) i--;
            else if(d[i][j] == d[i][j-1]) j--;
            else {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }

        }

        int t = d[s1.length()][s2.length()];
        if(t != 0) {
            System.out.println(t);
            System.out.println(sb.reverse());
        }
        else System.out.println(0);
        br.close();
    }

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}

