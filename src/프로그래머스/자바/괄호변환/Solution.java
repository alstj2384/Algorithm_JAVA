package 프로그래머스.자바.괄호변환;
import java.util.*;
class Solution {
    public String dfs(String s){
        // 1
        if(s.equals("")) return "";

        // 2
        int count = 0;
        int len = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') count += 1;
            else if(s.charAt(i) == ')') count -= 1;
            if(count == 0) {
                len = i+1;
                break;
            }
        }
        String u = s.substring(0, len);
        String v = s.substring(len, s.length());


        // 3
        count = 0;
        boolean flag = true;
        for(int i = 0; i < u.length(); i++){
            if(u.charAt(i) == '(') count += 1;
            else if(u.charAt(i) == ')') count -= 1;
            if(count < 0){
                flag = false;
                break;
            }
        }

        // 4
        if(flag){
            return u + dfs(v);

        } else{
            String t = "(" + dfs(v) + ")";
            String tmp = u.substring(1, u.length()-1);
            String result = "";
            for(int i = 0; i < tmp.length(); i++){
                if(tmp.charAt(i) == '(') result += ')';
                if(tmp.charAt(i) == ')') result += '(';
            }
            t += result;

            return t;
        }
    }
    public String solution(String p) {
        String answer = "";
        answer = dfs(p);
        return answer;
    }
}
