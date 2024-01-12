package 백준.자바.로또_6603;

import java.io.*;
import java.util.*;

public class Main {
    private StringBuilder sb = new StringBuilder();
    private int[] arr;
    void dfs(int at, int chosen, String s){
        if(at >= arr.length || chosen==6){
            if(chosen == 6)
                sb.append(s.strip()).append('\n');
            return;
        }
        for(int i = at; i < arr.length; i++){
            dfs(i+1, chosen+1, s+" "+arr[i]);
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(!(s=br.readLine()).equals("0")){
            StringTokenizer st = new StringTokenizer(s);

            int size = Integer.parseInt(st.nextToken());
            arr = new int[size];

            for(int i = 0; i < size; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0, "");
            sb.append('\n');
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
