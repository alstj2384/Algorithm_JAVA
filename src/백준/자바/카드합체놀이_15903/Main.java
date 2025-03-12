package 백준.자바.카드합체놀이_15903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < n; i++){
            pq.offer(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < m; i++){
            Long min1 = pq.poll();
            Long min2 = pq.poll();

            pq.offer(min1 + min2);
            pq.offer(min1 + min2);
        }

        Long sum = 0L;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }

        System.out.println(sum);
    }

}
