package SWEA.연월일_달력_2056;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};



        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++){
            sb.append("#" + t + " ");
            String s = br.readLine();

            String year = s.substring(0, 4);
            String month = s.substring(4, 6);
            int monthInt = Integer.parseInt(s.substring(4, 6));
            String day = s.substring(6);
            int dayInt = Integer.parseInt(s.substring(6));

            if(monthInt >= 1 && monthInt <= 12 && days[monthInt] >= dayInt){
                sb.append(year + "/" + month + "/" + day + "\n");
            }
            else{
                sb.append(-1).append('\n');
            }

        }

        System.out.println(sb);
    }
}
