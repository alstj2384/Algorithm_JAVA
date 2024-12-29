package 백준.자바.용돈관리_6236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] days;
    static boolean check(int x){
        // x원을 M번 인출해서 떼울 수 있는가?
        int cur = 0;
        int withdraw = 0;

        for(int day : days){
            if(cur < day){
                cur = x;
                withdraw += 1;
            }
            cur -= day;

            if(cur < 0) return false;
        }

        return withdraw <= M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        days = new int[N];

        for(int i = 0; i < N; i++){
            days[i] = Integer.parseInt(br.readLine());
        }

        int lo = 0;
        int hi = 1_000_000_001;
        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            boolean b = check(mid);
            if(b) { // T인 경우
                hi = mid;
            } else{
                lo = mid;
            }
        }

        System.out.println(hi);
    }
}
