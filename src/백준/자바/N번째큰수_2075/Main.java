package 백준.자바.N번째큰수_2075;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                pq.add(-Integer.parseInt(st.nextToken()));
            }
        }

        int val = 0;
        for(int i = 0; i < N; i++){
            val = -pq.poll();
        }

        System.out.println(val);
    }
}
