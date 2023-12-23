package 백준.자바;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//1:39~
public class BJ_14501 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int k = sc.nextInt();
        int[] day = new int[k];
        int[] price = new int[k];

        for(int i = 0 ; i < k; i++){
            day[i] = sc.nextInt();
            price[i] = sc.nextInt();
        }

        int[] sum = new int[k+1];
        for(int i = 0; i < k; i++){
            if(day[i] + i > k)
                continue;
            for(int j = i; j < k; j++){
                if(day[i] + j > k)
                    continue;
                sum[day[i] + j] = Math.max(sum[i] + price[i], sum[day[i]+j]);
            }

        }
        Arrays.sort(sum);
        System.out.println(sum[k-1]);
    }

}
