package 백준.자바.DSLR_9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static void bfs(){
        q.offer(A);
        visited[A] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            if(now == B){
                System.out.println(arr[now]);
                return;
            }


            // 4가지 수행
            command[0] = (now<<1)%10000;
            command[1] = now == 0 ? 9999 : now-1;
            command[2] = (now % 1000) * 10 + now / 1000;
            command[3] = (now % 10) * 1000 + now / 10;

            for(int i = 0; i < 4; i++) {
                if (!visited[command[i]]) {
                    arr[command[i]] = arr[now] + dslr[i];
                    q.offer(command[i]);
                    visited[command[i]]= true;
                }
            }

        }
    }
    static String[] dslr = {"D", "S","L","R"};
    static int A, B;
    static Queue<Integer> q;
    static int[] command = new int[4];
    static boolean[] visited ;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        for(int t= 0; t < T; t++){
            arr = new String[10000];
            Arrays.fill(arr, "");
            visited = new boolean[10000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();

            bfs();

        }

    }
}
