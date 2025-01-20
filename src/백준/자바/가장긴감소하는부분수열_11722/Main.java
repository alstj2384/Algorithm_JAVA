package 백준.자바.가장긴감소하는부분수열_11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] d = new int[n];
        int[] arr= new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            int max = -1;
            for(int j = 0; j < i; j++){
                // i 이전의 값들을 탐색

                if(arr[i] < arr[j]){
                    // 현재 값(i)보다 더 큰 수(j)를 찾으면
                    if(max < d[j]){
                        // 현재 최대 길이(max)보다 연속이 길면,
                        max = d[j];
                    }
                }
            }
            d[i] = max == -1 ? 1 : max+1;
        }

        Arrays.sort(d);
        System.out.println(d[n-1]);
    }
}
