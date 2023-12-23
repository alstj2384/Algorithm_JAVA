package 백준.자바.더게임오브데스_11558;

import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static Vector<Integer> v;
    static int n;

    static void game(int k, int cnt){
        if(k == n) {
            v.add(cnt);
            return;
        }
        if(!visited[k]) {
            visited[k] = true;
            game(arr[k], ++cnt);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        for(int i = 0; i < a; i++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            v = new Vector<>();

            for(int j = 1; j < n+1; j++)
                arr[j] = Integer.parseInt(br.readLine());

            game(1, 0);
            System.out.println(!v.isEmpty() ? Collections.min(v) : "0");
        }
    }
}
