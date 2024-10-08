package 백준.자바.Frog_Jump_26107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] dSum = new long[100005];

        // 현재 구간의 가장 긴 길이를 기억하고있다가, 다음 구간의 최솟값이 긴 길이보다 길면, 집합이 달라진다.(이때 거리 계산해서 누적합)
        // 현재 구간에서 가장 긴 길이
        int rightMax = 1;
        int setIndex = 1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if(left > rightMax){
                setIndex++;
                // 집합이 달라지고, 누적합 배열에 기록 (추후 초기화 필요)
                dSum[setIndex] = left - rightMax;
            }

            rightMax = Math.max(right, rightMax);

            map.put(i, setIndex);
        }

        for(int i = 1; i < setIndex+1; i++){
            dSum[i] += dSum[i-1];
        }

//        checkDsum(dSum, setIndex);

        st = new StringTokenizer(br.readLine());
        int prev = 1;
        long dist = 0;
        for(int i = 0; i < k; i++){
            // 스타팅 포인트는 1임
            int K = Integer.parseInt(st.nextToken());
            int prevSet = map.get(prev);
            int curSet = map.get(K);

            dist += Math.abs(dSum[prevSet] - dSum[curSet]);

            prev = K;
        }

        System.out.println(dist);
    }

    private static void checkDsum(long[] dSum, int setIndex) {
        // 누적합 확인
        for(int i = 1; i < setIndex +1; i++){
            System.out.print(dSum[i] + " ");
        }
        System.out.println();
    }
}
