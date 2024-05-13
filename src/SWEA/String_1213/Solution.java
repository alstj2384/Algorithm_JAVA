package SWEA.String_1213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++){

            int N = Integer.parseInt(br.readLine());
            sb.append("#" + N + " ");

            String find = br.readLine();
            String sentence = br.readLine();

            int index = 0;
            int count = 0;
            while(true) {
                int i = sentence.indexOf(find, index);
                if(i != -1){
                    index = i+1;
                    count++;
                } else{
                    break;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
}