package SWEA.육십갑자_19185;

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
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] SN = new String[N];
            String[] SM = new String[M];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                SN[i] = st.nextToken();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++)
                SM[i] = st.nextToken();

            int Q = Integer.parseInt(br.readLine());

            for(int i = 0; i < Q; i++){
                int K = Integer.parseInt(br.readLine())-1;
                int nIndex = K%N;
                int mIndex = K%M;
                sb.append(SN[nIndex]).append(SM[mIndex]).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }
}
