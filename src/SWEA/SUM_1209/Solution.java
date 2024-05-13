package SWEA.SUM_1209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int getDiagonal1(int[][] arr){
        int sum = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(i == j){
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    static int getDiagonal2(int[][] arr){
        int sum = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 99; j >= 0; j--){
                if(i + j == 99){
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++){
            int N = Integer.parseInt(br.readLine());

            sb.append("#" + N + " ");

            int[][] arr = new int[100][100];

            for(int i = 0; i < 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 100; i++){
                int sum = 0;
                for(int j = 0; j < 100; j++){
                    sum += arr[i][j];
                }
                max = Math.max(sum, max);
            }
            for(int i = 0; i < 100; i++){
                int sum = 0;
                for(int j = 0; j < 100; j++){
                    sum += arr[j][i];
                }
                max = Math.max(sum, max);
            }

            max = Math.max(getDiagonal1(arr), max);
            max = Math.max(getDiagonal2(arr), max);


            sb.append(max).append('\n');
        }
        System.out.print(sb);
    }
}
