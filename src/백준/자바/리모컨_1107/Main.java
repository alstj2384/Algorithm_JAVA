package 백준.자바.리모컨_1107;

import java.io.*;
import java.util.*;

public class Main {

    private int N, M;
    private int N_digit;
    private int[] delList;
    private List<Integer> numbers = new LinkedList<>();
    private int tmp;
    private int min = Integer.MAX_VALUE;

    void dfs(String s){

        if(!s.equals("")) {
            min = Math.min(Math.abs(Integer.parseInt(s) - N) + s.length(), min);
        }
        for(var k : numbers){
            tmp =  Integer.parseInt(s+k);
//            if(tmp < 0 || tmp > 1000000 || s.length()+1 > N_digit) continue;
            if(tmp < 0 || tmp > 1000000 || s.length() > N_digit) continue;
            dfs(s+k);

        }
    }


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        N_digit = Integer.toString(N).length();
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] delList = new int[M];
        if(M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                delList[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 10; i++) {
            boolean flag = false;
            for (int j = 0; j < M; j++) {
                if (delList[j] == i) {
                    flag = true;
                    continue;
                }
            }
            if (!flag) {
                numbers.add(i);
            }
        }



        min = Math.abs(N-100);

        dfs("");

        System.out.println(min);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
