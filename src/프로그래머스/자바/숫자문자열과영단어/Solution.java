package 프로그래머스.자바.숫자문자열과영단어;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] digit = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
                i++;
            }
            else{
                for(int j = 0; j < 10; j++){
                    if(i == s.indexOf(digit[j], i)){
                        sb.append(j);
                        i += digit[j].length();
                        break;
                    }
                }
            }
        }
        answer = Integer.parseInt(sb.toString());

        return answer;
    }
}