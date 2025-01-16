package 백준.자바.합분해_2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

        int[][] d = new int[201][201];

        for(int i = 0; i < 201; i++){
            d[i][0] = 1;
            d[0][i] = 1;
        }

        for(int i = 1; i < 201; i++){
            for(int j = 1; j < 201; j++){
                d[i][j] = (d[i-1][j] + d[i][j-1]) % 1_000_000_000;
            }
        }

        System.out.println(d[n][k-1]);
    }
}
