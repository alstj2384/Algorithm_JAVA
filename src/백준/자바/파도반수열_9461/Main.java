package 백준.자바.파도반수열_9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        long[] d = new long[101];

        d[1] = 1;
        d[2] = 1;
        d[3] = 1;

        for(int i = 4; i < 101; i++){
            d[i] = d[i-3] + d[i-2];
        }

        for(int T = 0; T < t; T++){
            int k = Integer.parseInt(br.readLine());
            System.out.println(d[k]);
        }
    }
}
