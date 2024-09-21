package 백준.자바.행복점수_30445;

import java.util.Scanner;

public class Main {
    static boolean isHappy(char c){
        return c == 'H' || c == 'A' || c == 'Y' || c == 'P';
    }

    static boolean isDepress(char c){
        return c == 'S' || c == 'A' || c == 'D';
    }

    static boolean isNan(double H, double G){
        return H == 0.0 && G == 0.0;
    }

    static double calC(double H, double G){
        return H / (H + G) * 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        double H = 0, G = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(isHappy(c)) H += 1;
            if(isDepress(c)) G += 1;
        }

        String result = String.format("%.2f", isNan(H, G) ? 50.00 : calC(H, G));
        System.out.println(result);
    }
}
