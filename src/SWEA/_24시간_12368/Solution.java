package SWEA._24시간_12368;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
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

            sb.append((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))%24).append('\n');
        }
        System.out.print(sb);
    }
}
