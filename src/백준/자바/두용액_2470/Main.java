package 백준.자바.두용액_2470;
import java.io.*;
import java.util.*;

public class Main {
    private int a, b, p, q, k;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[k];
        for(int i = 0 ; i < k; i++)
            arr[i] = Integer.parseInt(st.nextToken());


        Arrays.sort(arr);
        p = 0;
        q = k-1;
        int min = Integer.MAX_VALUE;

        // 탐색
        while(p < q){
            int sum = arr[p] + arr[q];
            if(min > Math.abs(sum)){
                min = Math.abs(sum);
                a = arr[p];
                b = arr[q];
            }
            if(sum > 0) q--;
            else if(sum < 0) p++;
            else{
                a = arr[p];
                b = arr[q];
                break;
            }
        }

        System.out.println(a + " " + b);
        br.close();
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
