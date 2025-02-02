package 백준.자바._30_10610;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();
        Character[] nArr = new Character[n.length()];

        // 배수 판정법
        // 3 -> 모든 자릿수의 합이 3으로 나누어떨어진다.
        // 10 -> 자릿수가 0으로 끝난다
        int k = 0;
        boolean hasZero = false;
        for(int i = 0;i < n.length();i ++){
            char val = n.charAt(i);
            nArr[i] = val;
            if(val =='0') hasZero = true;
            k += (val-'0');
        }

        if(!hasZero || k % 3 != 0){
            System.out.println(-1);
            return;
        }

        Arrays.sort(nArr, (a, b) -> b-a);

        for(var p : nArr)
            System.out.print(p);


    }
}
