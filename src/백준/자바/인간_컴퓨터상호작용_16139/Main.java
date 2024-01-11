package 백준.자바.인간_컴퓨터상호작용_16139;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[][] d = new int[26][s.length()+1];
        int[] index = new int[26];
        int N = Integer.parseInt(br.readLine());

        for(int i =1; i < s.length()+1; i++){
            for(int j = 0; j <26; j++){
                if(d[j][index[j]] != 0)
                    d[j][i] = d[j][index[j]];
            }
            int val = s.charAt(i-1)-'a';
            d[val][i] = d[val][index[val]]+1;
            index[val] = i;
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken())+1;
            sb.append((d[c-'a'][end] -d[c-'a'][start])).append('\n');
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
