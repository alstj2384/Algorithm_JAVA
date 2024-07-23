package 백준.자바.컵라면_1781;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class problem{
        int deadline;
        int ramen;
        public problem(int deadline, int ramen){
            this.deadline = deadline;
            this.ramen = ramen;
        }
    }

    // Deadline 내림차순 정렬
    static PriorityQueue<problem> pq = new PriorityQueue<>((o1, o2) ->
            Integer.compare(o2.deadline, o1.deadline));

    // 비교함수 compare(o2.x, o1.x) -> x 내림차순 정렬

    // ramen 오름차순 정렬
    static PriorityQueue<problem> pq2 = new PriorityQueue<>((o1, o2) ->
            Integer.compare(o2.ramen, o1.ramen));


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.add(new problem(a, b));
        }


        int deadLine = pq.peek().deadline;
        int count = 0;

        while(deadLine > 0){
            while(!pq.isEmpty()){
                int tmp = pq.peek().deadline;
                if(tmp < deadLine) break;
                pq2.add(pq.poll());
            }

            if(!pq2.isEmpty())
                count += pq2.poll().ramen;
            deadLine -= 1;
        }
        System.out.println(count);
    }
}
