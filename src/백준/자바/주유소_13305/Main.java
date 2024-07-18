package 백준.자바.주유소_13305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int road[], city[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        road = new int[N-1];
        city = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++) road[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) city[i] = Integer.parseInt(st.nextToken());

        int index = 0;
        long cost = 0L;
        while(true){
            if(index == N-1) break;
            long dist = 0L;
            int k = 0;
            while(index + k < N-1 && city[index] <= city[index + k]){
                  dist += road[index + k];
                  k++;
            }
            cost += city[index] * dist;
            index += k;
        }


        System.out.println(cost);
    }
}
