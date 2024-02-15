package 프로그래머스.자바.성격유형검사하기;
import java.util.*;
class Solution {

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] values = new int[4];

        for(int i = 0; i < survey.length; i++){
            char first = survey[i].charAt(0);

            int val=0;
            if(choices[i] == 1) val = 3;
            else if(choices[i] == 2) val = 2;
            else if(choices[i] == 3) val = 1;
            else if(choices[i] == 4) val = 0;
            else if(choices[i] == 5) val = -1;
            else if(choices[i] == 6) val = -2;
            else if(choices[i] == 7) val = -3;

            System.out.println(val);

            if(first == 'R') values[0] += val;
            if(first == 'T') values[0] -= val;
            if(first == 'C') values[1] += val;
            if(first == 'F') values[1] -= val;
            if(first == 'J') values[2] += val;
            if(first == 'M') values[2] -= val;
            if(first == 'A') values[3] += val;
            if(first == 'N') values[3] -= val;

        }
        StringBuilder sb = new StringBuilder();
        if(values[0] >= 0) sb.append('R');
        else sb.append('T');

        if(values[1] >= 0) sb.append('C');
        else sb.append('F');

        if(values[2] >= 0) sb.append('J');
        else sb.append('M');

        if(values[3] >= 0) sb.append('A');
        else sb.append('N');
        answer = sb.toString();
        return answer ;
    }
}