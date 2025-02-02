package 백준.자바.쇠막대기_10799;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int stick = 0;
        boolean isRazor = false;
        long sum = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stick += 1;
                isRazor = true;
            }
            else{
                stick -= 1;
                if(isRazor) {
                    sum += stick;
                }else{
                    sum += 1;
                }
                isRazor = false;
            }

        }

        System.out.println(sum);
    }
}
