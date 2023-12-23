package 백준.자바;
import java.util.*;

public class BJ_1149 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[][] d = new int[3][n];
        int[][] cost = new int[3][n];
        for(int i =0; i < n; i++)
            for(int j = 0; j < 3; j++)
                cost[j][i] = sc.nextInt();

        d[0][0] = cost[0][0];
        d[1][0] = cost[1][0];
        d[2][0] = cost[2][0];

        for(int i = 1; i < n; i++){
            d[0][i] = Math.min(d[1][i-1], d[2][i-1]) + cost[0][i];
            d[1][i] = Math.min(d[0][i-1], d[2][i-1]) + cost[1][i];
            d[2][i] = Math.min(d[0][i-1], d[1][i-1]) + cost[2][i];
        }

        System.out.println(Math.min(Math.min(d[0][n-1], d[1][n-1]), d[2][n-1]));
    }
}
