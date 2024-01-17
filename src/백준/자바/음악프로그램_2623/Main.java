package 백준.자바.음악프로그램_2623;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        boolean[][] arr = new boolean[N][N];
        int[] entryCount = new int[N];

        // 입력 받기
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int front = Integer.parseInt(st.nextToken())-1;
            if(p == 1) continue;

            for(int j = 0; j < p-1; j++){
                int back = Integer.parseInt(st.nextToken())-1;
                if(!arr[front][back]) {
                    arr[front][back] = true;
                    entryCount[back]++;
                }
                front = back;
            }
        }

        // 위상 정렬을 위해 진입 차수가 0인 인덱스 삽입
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(entryCount[i] == 0)
                q.offer(i);
        }


        // 위상 정렬 알고리즘 실행
        while(!q.isEmpty()){
            int index = q.poll();
            sb.append(index+1).append('\n');

            for(int i = 0; i < N; i++){
                if(arr[index][i]){
                    // 해당 가수로의 간선 존재 시 간선 삭제하기
                    arr[index][i] = false;
                    entryCount[i]--;
                    // 진입 차수가 0이 되면 큐에 삽입
                    if(entryCount[i] == 0) q.offer(i);
                }
            }
        }

        System.out.println(sb.toString().length()/2 < N ? 0 : sb);
        br.close();
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}