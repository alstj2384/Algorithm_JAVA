package SWEA.간단한_369게임_1926;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++){
            int k = i;
            int count = 0;
            while(k / 10 != 0){
                if(k / 10 == 3 || k / 10 == 6 || k / 10 == 9){
                    count++;
                }
                k -= 10*(k / 10);
            }
            if(k == 3 || k == 6 || k == 9) count++;

            if(count > 0){
                for(int j = 0; j < count; j++) sb.append('-');
                sb.append(" ");
            } else{
                sb.append(i + " ");
            }
        }
        System.out.println(sb);

    }
}
