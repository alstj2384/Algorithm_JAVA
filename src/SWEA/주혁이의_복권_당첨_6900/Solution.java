package SWEA.주혁이의_복권_당첨_6900;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++){
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] code = new String[N];
            int[] money = new int[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());

                code[i] = st.nextToken();
                money[i] = Integer.parseInt(st.nextToken());
            }
            int sum = 0;
            for(int i = 0; i < M; i++){
                String s = br.readLine();
                for(int j = 0; j < N; j++){
                    boolean isSame = true;
                    for(int x = 0; x < 8; x++){
                        if(code[j].charAt(x) == '*') continue;
                        if(s.charAt(x) != code[j].charAt(x)){
                            isSame = false;
                            break;
                        }
                    }

                    if(isSame) sum += money[j];
                }
            }
            sb.append(sum).append('\n');

        }
        System.out.println(sb);
    }
}
