package 백준.자바.한동이는공부가하기싫어_3182;
import java.io.*;
import java.util.*;

public class Main {
    private int[] arr;
    private boolean[] visited;
    private int count;
    private void dfs(int x){
        visited[x] = true;
        if(!visited[arr[x]]){
            dfs(arr[x]);
        }
        count++;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for(int i =1 ; i < N+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ask = 0;
        int min = Integer.MIN_VALUE;
        for(int i = 1; i < N+1; i++){
            visited = new boolean[N+1];
            count = 0;
            dfs(i);
            if(min < count){
                ask = i;
                min =count;
            }
        }
        System.out.println(ask);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}