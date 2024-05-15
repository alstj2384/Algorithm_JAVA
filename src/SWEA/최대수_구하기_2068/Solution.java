package SWEA.최대수_구하기_2068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++){
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 10; i++){
                max = Math.max(max, Integer.parseInt(st.nextToken()));
            }

            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }
}
