package SWEA.Flatten_1208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++){
            sb.append("#" + test_case + " ");
            int N = Integer.parseInt(br.readLine());
            int[] box = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 100; i++) box[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(box);
            for(int i = 0; i < N; i++){
                int left = 0;
                int right = 99;

                while(box[left+1] == box[left]) left++;
                if(box[left+1] > box[left]) box[left]++;

                while(box[right-1] == box[right]) right--;
                if(box[right-1] < box[right]) box[right]--;
            }
            sb.append(box[99] - box[0]).append('\n');
        }
        System.out.print(sb);
    }
}
