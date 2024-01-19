package 백준.자바.수들의합_1789;


import java.io.*;
import java.util.*;

public class Main {
    private long S;
    boolean Check(long x){
        // 결정 문제 : x를 식에 대입한 값이 S보다 작거나 같으면 True
        return (x*(x+1))/2 <= S;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Long.parseLong(br.readLine());

        long lo = 1;
        long hi = 4294967295L;

        while(lo + 1 < hi){
            long mid = (lo + hi) / 2;
            if(Check(mid)) lo = mid;
            else hi = mid;
        }

        // 탐색 결과
        // lo = 합이 S와 같거나 작은 값중 최대값
        // hi = 합이 S보다 큰 값중 최소값
        // hi에서 임의의 자연수 하나를 빼서 만든 값의 자릿수 N == hi-1 == lo
        System.out.println(lo);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
