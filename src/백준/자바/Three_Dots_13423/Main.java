package 백준.자바.Three_Dots_13423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test = 0; test < T; test++){
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int arr[] = new int[N];

            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < N; i++){
                map.put(arr[i], i);
            }

            // 1 ~ N-2 범위에서, 가장 좌측(arr[0])과 가장 우측(arr[N-1]) 의 값을 비교, 더 작은 쪽부터 시작
            // 해당 번호(가장 좌측)부터 중앙 값과의 절대값 차이가 map에 존재하는지 확인, 존재 시 count ++

            int count = 0;
            for(int i = 1; i < N-1; i++){
                int val = arr[i];
                if(val - arr[0] > arr[N-1] - val){
                    // 왼쪽 차이 값이 오른쪽 차이 값보다 큰 경우 -> 오른쪽 기준으로 시작
                    for(int j = N-1; j > i; j--){
                        // 오른쪽부터 확인
                        int diff = val - arr[j];
                        if(map.containsKey(arr[i] + diff)){
                            count += 1;
                        }
                    }
                }

                else {
                    for(int j = 0; j < i; j++){
                        // 왼쪽부터 확인
                        int diff = arr[j] - val;
                        if(map.containsKey(arr[i] - diff)){

                            count += 1;
                        }
                    }
                }
            }
            System.out.println(count);
        }


    }
}
