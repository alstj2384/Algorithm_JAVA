package 알고스팟.PICNIC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int C, N, M, count;
    static boolean[][] friends;
    static boolean[] visited;
    static int findPair(){
        int firstFree = -1;
        int ret = 0;
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                firstFree = i;
                break;
            }
        }
        if(firstFree == -1) return 1;
        for(int i = firstFree + 1; i < N; i++){
            if(!visited[i] && friends[firstFree][i]){
                visited[firstFree] = visited[i] = true;
                ret += findPair();
                visited[firstFree] = visited[i] = false;
            }
        }
        return ret;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        C = Integer.parseInt(br.readLine());

        for(int test = 0 ; test < C; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            count = 0;
            friends = new boolean[N][N];
            visited = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for(int i  =0; i < M; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                friends[a][b] = friends[b][a] = true;
            }

            System.out.println(findPair());
        }




    }
}
