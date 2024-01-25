package 백준.자바.A와B_12904;


import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();
        int index = t.length()-1;
        StringBuilder sb = new StringBuilder(t);
        while(sb.length() > s.length()){
            if(sb.charAt(index) == 'A') {
                sb.deleteCharAt(index);
            }
            else{
                sb.deleteCharAt(index);
                sb.reverse();
            }
//            System.out.println(sb);
            index--;
        }

        System.out.println(sb.toString().equals(s) ? 1 : 0);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
