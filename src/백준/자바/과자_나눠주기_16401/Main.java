package 백준.자바.과자_나눠주기_16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 목표
     * - 나눠줄 수 있는 막대과자의 최대 길이를 구하는 것
     *
     * 결정문제
     * - x 길이로 과자를 분할했을 때, M개 이상 나오는 가?(T, F)
     * - L의 최대길이 = 10^9 (10억)
     * - lo, hi는 언제나 정답의 범위를 포함해야한다
     * - 0 ~ n의 범위가 답이라면, -1 ~ n+1로 범위를 설정해야함.
     * - lo(T) = -1, hi(F) = 1,000,000,001
     * - T..TF..F -> T중 최댓값이어야 하므로, lo 반환
     */
    static int M, N;
    static int[] L;
    static boolean check(int x){
        int count = 0;
        for(int k : L){
            count += k / x;
            if(count >= M) return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            L[i] = Integer.parseInt(st.nextToken());
        }



        int lo = 0;
        int hi = 1_000_000_001;

        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            boolean b = check(mid);
            // T.. TF ... F
            if(b){ // b == T,
                lo = mid;
            } else{
                hi = mid;
            }
        }
        System.out.println(lo);
    }
}
