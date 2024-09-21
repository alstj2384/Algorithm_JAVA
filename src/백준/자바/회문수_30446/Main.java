package 백준.자바.회문수_30446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static final int MAX_N = 5;
    static long N, count;
    static int[] num = new int[MAX_N];
    static int sLen;
    static StringBuilder sb = new StringBuilder();
    static void calC(int depth){
        sb = new StringBuilder();

        for(int j = 0; j < depth-1; j++){
            sb.append(num[j]);
        }

        String s = sb.toString();
        String reversed = sb.reverse().toString();
        if(Long.parseLong(s + num[depth-1] + reversed) <= N){
            count += 1;
        }

        if(Long.parseLong(s +  num[depth-1] +  num[depth-1] + reversed)<= N){
            count += 1;
        }
    }

    static void dfs(int depth){
        if(depth == 0){
            for(int i = 1; i < 10; i++){
                num[depth] = i;
                dfs(depth + 1);
            }
            return;
        }

        calC(depth);

        if(depth >= sLen) {
            return;
        }
        // 탈출조건 : depth가 N의 길이 / 2보다 크거나 같을 때(최대 N = 10, 5까지는 해야함, 6부터 X)

        for(int i = 0; i < 10; i++){
            num[depth] = i;
            dfs(depth+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());

        sLen = String.valueOf(N).length() % 2 == 0 ? String.valueOf(N).length()/2 : String.valueOf(N).length()/2+1;
        dfs(0);

        System.out.println(count);

    }
}
