package 백준.자바.두배열의합_2143;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for(int i = 0; i < N; i++)
            a[i] = Integer.parseInt(st.nextToken());

        long[] dA = new long[N*(N+1)/2];
        int index = 0;
        for(int i = 0; i < N; i++){
            int ad = 0;
            for(int j = i; j < N; j++){
                ad += a[j];
                dA[index++] = ad;
            }
        }
        int M = Integer.parseInt(br.readLine());
        int[] b = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
            b[i] = Integer.parseInt(st.nextToken());

        long[] dB = new long[M*(M+1)/2];
        index = 0;
        for(int i = 0; i < M; i++){
            int bd = 0;
            for(int j = i; j < M; j++){
                bd += b[j];
                dB[index++] = bd;
            }
        }

        Arrays.sort(dA);
        Arrays.sort(dB);

        int left = 0;
        int right = dB.length-1;
        long count = 0;

        while(left < dA.length && right > -1){
            long aVal = dA[left], bVal = dB[right];
            long val = aVal + bVal;

            if(val == T) {
                long ac = 0, bc = 0;
                while (left < dA.length && aVal == dA[left]) {
                    left++;
                    ac++;
                }
                while (right > -1 && bVal == dB[right]) {
                    right--;
                    bc++;
                }
                count += ac * bc;
            }
            else if(val > T) right--;
            else left++;
            }
        System.out.println(count);
        }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
