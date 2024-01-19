package 백준.자바.나무자르기_2805;


import java.io.*;
import java.util.*;

public class Main {

    private int[] trees;
    private int N, M;
    boolean Check(int val){
        // 높이 val로 자를 시 m 이상의 나무를 가져간다면 True, or False
        long answer = 0;
        for(int i = 0; i < N; i++){
            if(trees[i] > val) answer += trees[i]-val;
        }
        return answer >= M;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            trees[i] = Integer.parseInt(st.nextToken());

        int lo = 0;
        int hi = 1000000000;

        // lo, hi가 각각 check(lo) != check(hi)여야함,
        // check(lo)는 0 모든 나무를 베기에 무조건 True
        // check(hi)는 10억(나무의 최대 높이)에서 베기에 1 이상은 존재할 수 없음 False
        // 결과적으로 check(lo) != check(hi)
        // low 와 hi 구간에 값이 변하는 경계가 있음
        while(lo + 1 < hi){
            int mid = (lo + hi) /2;
            if(Check(mid)) lo = mid;
            else hi = mid;
        }

        // 수행 결과
        // lo = T가 되는 값중 최댓값에 위치함
        // hi = F가 되는 값중 최솟값에 위치함
        // 문제에서는 결정문제가 T인 경우의 최댓값을 요구하므로 lo를 출력
        System.out.println(lo);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
