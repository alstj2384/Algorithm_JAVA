package 백준.자바.카드게임_24435;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int MAX_N = 8;
    static int T, N;
    static StringBuilder sb;
    static int[] val = new int[MAX_N];
    static int[] alice = new int[MAX_N];
    static int bob, curMax; // bob > curMax 상황에서 MAX값
    static boolean[] visited=  new boolean[MAX_N];
    static void dfs(int count, int limit){
        if(limit == count){

            int k = 0;
            for(int i = count-1; i >= 0; i--){
                k += (int)Math.pow(10, i) * val[i];
            }

            if(bob > k){
                curMax = Math.max(curMax, k);
            }
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]) {
                val[count] = alice[i];
                visited[i] = true;
                dfs(count + 1, limit);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int test = 0; test < T; test++){
            sb=  new StringBuilder();
            N = Integer.parseInt(br.readLine());

            sb.append(br.readLine());


            bob = Math.min(Integer.parseInt(sb.toString()), Integer.parseInt(sb.reverse().toString()));

            String a = br.readLine();
            for(int i = 0 ; i < N; i++){
                alice[i] = a.charAt(i) - '0';
            }

            curMax = Integer.MIN_VALUE;
            for(int i = 1; i < N+1; i++){
                dfs(0, i);
            }
            System.out.println(curMax);
        }

    }
}
