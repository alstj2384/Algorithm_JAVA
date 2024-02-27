package 백준.자바.단어공부_1157;
import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] arr = new int[26];

        s = s.toUpperCase();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            arr[c-'A'] += 1;
        }

        int max = 0;
        char maxChar = ' ';

        for(int i = 0; i < 26; i++){
            if(max < arr[i]){
                max = arr[i];
                maxChar = (char)(i+'A');
            }
            else if(max > 0 && max == arr[i]){
                maxChar = '?';
            }
        }
        System.out.println(maxChar);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
