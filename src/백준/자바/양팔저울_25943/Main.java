package 백준.자바.양팔저울_25943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int left = 0, right = 0;

        left += Integer.parseInt(st.nextToken());
        right += Integer.parseInt(st.nextToken());

        for(int i = 2; i < N; i++){
            int t = Integer.parseInt(st.nextToken());

            if(left == right){
                left += t;
            } else{
                if(left > right) right += t;
                else left += t;
            }
        }

        int diff = Math.abs(left - right);

        int[] w = {100, 50, 20, 10, 5, 2, 1};
        int count = 0;

        for(int i  =0; i < 7; i++){
            if(diff >= w[i]){
                int t = diff / w[i];
                diff -= w[i] * t;
                count += t;
            }
        }

        System.out.println(count);

    }
}
