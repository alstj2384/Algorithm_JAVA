package 백준.자바.로또_6603_2;

import java.io.*;
import java.util.*;

public class Main {
    int n;
    int[] arr, buffer = new int[6];
    StringBuilder sb = new StringBuilder();
    void dfs(int arrIdx, int bufferIdx){
        if(bufferIdx > 5){
            for(int i = 0; i < 6; i++){
                sb.append(buffer[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        if(arrIdx >= n) return;

        buffer[bufferIdx] = arr[arrIdx];
        dfs(arrIdx+1, bufferIdx +1);
        dfs(arrIdx+1, bufferIdx);
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String s = "";
        while(!(s = br.readLine()).equals("0")){
            st = new StringTokenizer(s);

            n = Integer.parseInt(st.nextToken());
            arr = new int[n];

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            sb.append('\n');
        }
        System.out.print(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}