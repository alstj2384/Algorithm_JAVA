package SWEA.회문의_회문_20019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static boolean isPalindrome(String s){
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t < T+1; t++){
            String s = br.readLine();

            int val = (s.length()-1)/2;

            if(isPalindrome(s.substring(0, val)) && isPalindrome(s.substring(s.length()-val)) && isPalindrome(s)){
                System.out.println("#"+ t + " " + "YES");
            }else{
                System.out.println("#"+ t + " " + "NO");
            }
        }
    }
}
