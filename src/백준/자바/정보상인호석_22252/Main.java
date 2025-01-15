package 백준.자바.정보상인호석_22252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Q = Integer.parseInt(br.readLine());
        HashMap<String, PriorityQueue<Integer>> map = new HashMap<String, PriorityQueue<Integer>>();


        long sum = 0;
        while(Q > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int val = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> pq = null;

            if(val == 1){
                if(map.get(name) == null){
                    pq = new PriorityQueue<Integer>((a, b) -> -Integer.compare(a, b));
                    map.put(name, pq);
                }
                else pq =  map.get(name);

                for(int i = 0; i < k; i++){
                    int t = Integer.parseInt(st.nextToken());
                    pq.offer(t);
                }
            }
            else{
                if(map.get(name) != null){
                    pq = map.get(name);
                    k = Math.min(k, pq.size());
                    while(k > 0){
                        sum += pq.poll();
                        k--;
                    }
                }
            }
            Q--;
        }
        System.out.println(sum);

    }
}
