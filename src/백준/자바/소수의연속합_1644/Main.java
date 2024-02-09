package 백준.자바.소수의연속합_1644;
import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n==1) {
            System.out.println(0);
            return;
        }
        boolean[] isPrime = new boolean[n+1];

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(isPrime[i]){
                for(int j = i*i; j <= n; j+= i){
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;

        long[] d = new long[Math.min(283148, n+1)];


        d[1] = 2;
        for(int k = 2, i = 3; i < n+1; i++) {
            if(isPrime[i]){
                d[k] = d[k-1] + i;
                k++;
            }
        }

        int lo = 0;
        int hi = 1;
        while(d[hi] != 0){
            long val = d[hi] - d[lo];
            if(val < n) hi++;
            else if(val > n) lo++;
            else {
                count++;
                hi++;
            }
        }
        System.out.println(count);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
