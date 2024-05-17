package SWEA.조별과제_13218;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++){
            sb.append("#" + t + " ");

            int N = Integer.parseInt(br.readLine());

            sb.append(N/3).append('\n');
        }
        System.out.print(sb);
    }
}
