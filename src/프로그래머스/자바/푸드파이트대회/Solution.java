package 프로그래머스.자바.푸드파이트대회;
import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            for(int j = 0; j < food[i]/2; j++){
                sb.append(i);
            }
        }
        String s = sb.toString();
        String rev = sb.reverse().toString();
        answer = s + "0"+rev;
        return answer;
    }
}