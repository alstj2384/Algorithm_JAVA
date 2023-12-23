package 백준.자바;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int p = 0; p < k; p++) {
            int n = Integer.parseInt(br.readLine());
            int[][] d = new int[3][n];

            StringTokenizer st= null;
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int q = 0; q < n; q++)
                    d[j][q] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < n; i++) {
                d[0][i] = Math.max(d[1][i - 1], d[2][i - 1]) + d[0][i];
                d[1][i] = Math.max(d[0][i - 1], d[2][i - 1]) + d[1][i];
                d[2][i] = Math.max(d[1][i - 1], Math.max(d[0][i - 1], d[2][i - 1])) ;
            }

            System.out.println(Math.max(Math.max(d[0][n - 1], d[1][n - 1]), d[2][n - 1]));
        }
    }
}
