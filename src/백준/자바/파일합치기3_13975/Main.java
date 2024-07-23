package 백준.자바.파일합치기3_13975;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test = 0; test < T; test++){
            PriorityQueue<Long> pq = new PriorityQueue<>();

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                pq.add(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while(pq.size() > 1){
                Long a = pq.poll();
                Long b = pq.poll();

                sum += a + b;
                pq.add(a + b);
            }

            System.out.println(sum);
        }


    }
}
