package 백준.자바.Double_Rainbow_23567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];


        int[] P = new int[k+1];
        int[] PP = new int[k+1];
        // 각각 P[1] = 구간 P에서 1의 출현 횟수를 의미

        int PCount = 0;
        int PPCount = 0;
        // 각각 P에 포함된 자연수 종류의 개수 의미
        // P = [0, 1, 2, 0, 0] -> 1이 1번, 2가 2번 나타남
        // PCount = 2 (1과 2가 있으므로)

        for(int i  =0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            P[arr[i]] += 1;
        }

        boolean isImpossible = false;
        for(int i = 0; i < k+1; i++)
            if(P[i] != 0) {
                if(P[i] == 1) isImpossible = true;
                PCount += 1;
            }
        // PCount 초기값 세팅

        if(isImpossible){
            System.out.println(0);
            return;
        }

        int left = 0;
        int right = -1;
        int dist = Integer.MAX_VALUE;

        // 오른쪽이 n보다 같거나 커지는 순간 더 이상 끝났다고 판단할 수 있음
        while(true){
            if(PPCount < k){
                right += 1;

                // 종료 조건
                if(right >= n) break;

                // 새로운 right 범위에 대해 각 배열 값 조정
                PP[arr[right]] += 1;
                if(PP[arr[right]] == 1) PPCount += 1;

                P[arr[right]] -= 1;
                if(P[arr[right]] == 0) PCount -= 1;

            } else{
                // 새로운 left 범위에 대해 각 배열 값 조정
                PP[arr[left]] -= 1;
                if(PP[arr[left]] == 0) PPCount -= 1;

                P[arr[left]] += 1;
                if(P[arr[left]] == 1) PCount += 1;


                // 범위 조정 이후, PCount 와 PPCount가 모두 k이면, 둘 다 모든 자연수를 포함한 상태이다
                if(PCount == k)
                    dist = Math.min(dist, right - left + 1);

                // 기존 포함되었던 left에 대하여 처리 해준 후, left를 더해준다
                left += 1;
            }
        }


        System.out.println(dist == Integer.MAX_VALUE ? 0 : dist);




    }
}
