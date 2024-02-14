package 백준.자바.가운데를말해요_1655;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        int max, min;
        for(int i = 0; i < N; i++){
            int k = Integer.parseInt(br.readLine());

            if(maxPq.size() == minPq.size()) maxPq.add(k);
            else minPq.add(k);

            if(!minPq.isEmpty()){
                if(maxPq.peek() > minPq.peek()) {
                    max = minPq.poll();
                    min = maxPq.poll();
                    minPq.add(min);
                    maxPq.add(max);
                }
            }

            if(maxPq.size() > minPq.size()){
                sb.append(maxPq.peek()).append('\n');
            }else{
                sb.append(minPq.peek() < maxPq.peek() ? minPq.peek() : maxPq.peek()).append('\n');
            }
        }

        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
