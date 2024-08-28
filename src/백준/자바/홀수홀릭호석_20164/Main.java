package 백준.자바.홀수홀릭호석_20164;

import java.util.Scanner;

public class Main {
    static String s;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static void dfs(String s, int val){
        // 홀수를 세는 것은 진입할 때
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i)-'0') % 2 == 1){
                val += 1;
            }
        }

        if(s.length() == 1){
            min = Math.min(val, min);
            max = Math.max(val, max);
            return;
        }

        if(s.length() == 2){
            // 두 자리 일때
            String k = Integer.toString((s.charAt(0) - '0') + (s.charAt(1) - '0'));
            dfs(k, val);
            return;
        }
        if(s.length() >= 3){
            for(int i = 1; i < s.length()-1; i++){

                for(int j = i+1; j < s.length(); j++){
                    int i1 = Integer.parseInt(s.substring(0, i));
                    int i2 = Integer.parseInt(s.substring(i, j));
                    int i3 = Integer.parseInt(s.substring(j));
                    String k = String.valueOf(i1+i2+i3);
                    dfs(k, val);
                }
            }
            // 여기가 관건
        }

    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        s = sc.next();

        dfs(s, 0);
        System.out.println(min + " " + max);

    }
}
