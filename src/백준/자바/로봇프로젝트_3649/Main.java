package 백준.자바.로봇프로젝트_3649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x= 0;

        while(true) {
            try{
                x = Integer.parseInt(br.readLine()) * 10_000_000;
            } catch(Exception e){
                break;
            }

            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int lo = 0;
            int hi = n - 1;
            boolean ok = false;

            while (lo < hi) {
                int val = arr[lo] + arr[hi];

//            System.out.println(arr[lo] + " " + arr[hi]);
                if (val > x) {
                    hi -= 1;
                } else if (val < x) {
                    lo += 1;
                } else {
                    ok = true;
                    break;
                }
            }
            if(ok) System.out.println("yes " + arr[lo] + " " + arr[hi]);
            else System.out.println("danger");
        }
    }
}
