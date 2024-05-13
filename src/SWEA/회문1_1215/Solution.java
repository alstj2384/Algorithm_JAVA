package SWEA.회문1_1215;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++){
            sb.append("#" + test_case + " ");

            int N = Integer.parseInt(br.readLine());

            char[][] arr = new char[8][8];

            for(int i = 0; i < 8; i++){
                String s = br.readLine();
                for(int j = 0; j < 8; j++){
                    arr[i][j] = s.charAt(j);
                }
            }

            int count = 0;
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){

                    String s1 = findSentenceX(i, j, N, arr);
                    String s2 = findSentenceY(i, j, N, arr);
                    if(s1 != null)
                        if(is_palindrome(s1)) count++;
                    if(s2 != null)
                        if(is_palindrome(s2)) count++;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    private static boolean is_palindrome(String s) {
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    private static String findSentenceX(int i, int j, int n, char[][] arr) {
        // 가로 검사 (i)
        StringBuilder sb = new StringBuilder();
        if(i + n < 9){
            for(int a = i; a < i+n; a++)
                sb.append(arr[a][j]);
            return sb.toString();
        } else{
            return null;
        }
    }
    private static String findSentenceY(int i, int j, int n, char[][] arr) {
        // 세로 검사 (j)
        StringBuilder sb = new StringBuilder();

        if(j + n < 9){
            for(int a = j; a < j+n; a++)
                sb.append(arr[i][a]);
            return sb.toString();
        } else{
            return null;
        }
    }
}