package 백준.자바.텀프로젝트_9466;

import java.io.*;
import java.util.*;

public class Main {
    private int T, N;
    private int[] arr;
    private boolean[] visited, done;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int a = 0; a < T; a++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];
            done = new boolean[N+1];
            count = 0;

            for(int i = 1; i < N+1; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for(int i = 1; i < N+1; i++){
                if(!done[i]){
                    dfs(i);
                }
            }
            sb.append(N-count).append('\n');
        }
        System.out.println(sb);
    }

    private int count;

    private void dfs(int start){ // start = 값, target = 인덱스값
        // 이미 방문 했을 때!
        if(visited[start]){
            done[start] = true;    // 팀 편성 완료했다고 처리
            count++;    // 팀 편성 완료 인원 증가
        }else{
            // 방문하지 않았을 때 -> 방문 처리!
            visited[start] = true;
        }

        // 다음 학생이 팀 결성을 아직 못했을 경우
        if(!done[arr[start]]){
            dfs(arr[start]);
        }

        visited[start] = false;
        done[start] = true;



    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
