package 백준.자바.보석상자_2792;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Integer[] arr;

    static boolean check(int k) {
        // k 만큼의 질투심으로 나눠줄 수 있는가?
        if(k == 0) return false;
        int index = 0;
        int man = N;

        while(true) {
            if(index >= M) return true;
            int val = arr[index] / k;
            if (arr[index] % k != 0) val += 1;

            index += 1;
            man -= val;

            if (man < 0) return false;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Integer[M];

        for(int i = 0; i < M; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());


        int lo = 0;
        int hi = arr[0] + 1;

        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            boolean chk = check(mid);
            if(chk == check(lo)){
                lo = mid;
            } else if(chk == check(hi)){
                hi = mid;
            }
        }

        System.out.println(hi);


    }
}
