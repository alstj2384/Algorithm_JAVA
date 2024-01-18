package 백준.자바.볼링점수계산_17215;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int frame = 0;
        int strike1 = 0;
        int strike2 = 0;
        boolean spare = false;

        int score = 0;
        for(int i = 0; i < s.length(); i++){
            frame++;
            if(frame == 10){
                // 첫 번째 공
                char first = s.charAt(i);
                if(first == 'S'){
                    if(spare) score += 10;
                    if(strike1 > 0) {
                        score+= 10;
                        strike1--;
                    }
                    if(strike2 > 0){
                        score+= 10;
                    }
                    score += 10;

                    char second = s.charAt(i+1);
                    if(Character.isDigit(second)) {
                        score += second-'0';
                        if(strike1 > 0){
                            score += second-'0';
                        }
                    }
                    else if(second == 'S'){
                        score += 10;
                        if(strike1 > 0)
                            score += 10;
                    }

                    char third = s.charAt(i+2);
                    if(Character.isDigit(third)) score += third-'0';
                    else if(third == 'S') score +=10;
                    else if(third == 'P') {
                        if(Character.isDigit(second)){
                            score += 10-(second-'0');
                        }
                        else score += 10;
                    }
                    break;
                }

                if(Character.isDigit(first)){
                    score += first-'0';
                    if(spare) score += first-'0';

                    if(strike1 > 0) {
                        score+= first-'0';
                        strike1--;
                    }
                    if(strike2 > 0){
                        score+= first-'0';
                        strike2--;
                    }
                }
                else{
                    strike1--;
                }

                char second = s.charAt(i+1);

                if(second == 'P'){
                    if(Character.isDigit(first)) {
                        score += 10 - (first - '0');
                        if (strike1 > 0) {
                            score += 10 - (first - '0');
                        }
                    }
                    else{
                        score += 10;
                        if(strike1 > 0){
                            score += 10;
                        }
                    }

                    char third = s.charAt(i+2);
                    if(Character.isDigit(third)) score += third-'0';
                    if(third == 'S') score += 10;
                    break;
                }

                else if(Character.isDigit(second)){
                    if(strike1 > 0){
                        score += second-'0';
                    }
                    score += second-'0';
                }
                break;
                // 규칙을 다르게


            }

            // 첫 번째 공
            char first = s.charAt(i);
            if(first == 'S'){
                if(strike1 > 0) score += 10;
                if(strike2 > 0) score += 10;
                score += 10;

                if(spare) {
                    score += 10;
                    spare = false;
                }

                if(strike1 > 0){
                    strike2 = 1;
                    strike1 = 2;
                }
                else strike1 = 2;

                continue;
            }

            else if(Character.isDigit(first)){
                score += first-'0';
                if(spare) score += first-'0';

                if(strike1 > 0) score += first-'0';
                if(strike2 > 0) score += first-'0';
            }

            if(spare) spare = false;

            if(strike1 > 0) strike1--;
            if(strike2 > 0) strike2--;


            // 두 번째 공
            char second = s.charAt(i+1);

            // 두 번째 공까지 탐색했으니 i++로 순서 맞춰주기
            i++;

            if(second == 'P'){
                spare = true;
                if(first != '-') {
                    score += 10 - (first - '0');
                    if (strike1 > 0) score += 10 - (first - '0');
                }
                else{
                    score += 10;
                    if (strike1 > 0) score += 10;
                }
            }

            else if(Character.isDigit(second)){
                score += second-'0';
                if(strike1 > 0) score += second-'0';
            }

            if(strike1 > 0) strike1--;
        }

        System.out.println(score);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}

