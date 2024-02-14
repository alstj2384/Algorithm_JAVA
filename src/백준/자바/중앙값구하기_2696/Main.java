package 백준.자바.중앙값구하기_2696;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int max, min;
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < t; k++){
            int count = 0;
            int m = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minPq = new PriorityQueue<>();

            StringTokenizer st = null;
            sb.append((m+1)/2).append('\n');
            for(int i = 0; i < m; i++){
                if(i%10 == 0){
                    st = new StringTokenizer(br.readLine());
                }
                int n = Integer.parseInt(st.nextToken());

                if(maxPq.size() == minPq.size())
                    maxPq.add(n);
                else minPq.add(n);

                if(!minPq.isEmpty()){
                    if(maxPq.peek() > minPq.peek()) {
                        max = minPq.poll();
                        min = maxPq.poll();
                        minPq.add(min);
                        maxPq.add(max);
                    }
                }
                if(i%2 == 0) {
                    if(count == 9 || i == m-1){
                        sb.append(maxPq.peek() + "\n");
                        count = 0;
                    } else{
                        sb.append(maxPq.peek() + " ");
                    }
                    count++;
                }
            }
        }
        System.out.print(sb);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
