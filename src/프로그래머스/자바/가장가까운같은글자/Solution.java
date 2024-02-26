package 프로그래머스.자바.가장가까운같은글자;
import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int[] arr = new int[26];

        answer = new int[s.length()];

        Arrays.fill(arr, -1);

        for(int i =0 ; i < s.length(); i++){
            char c = s.charAt(i);

            if(arr[c-'a']== -1){
                answer[i] = -1;
                arr[c-'a'] = i;
            }else{
                answer[i] = i - arr[c-'a'];
                arr[c-'a'] = i;
            }
        }
        return answer;
    }
}