package 백준.자바.진법변환2_11005;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int[] digit = new int[31];

        int first = 0;
        for(int i = 31; i >= 0; i--){
            int k = (int)Math.pow(b, i);
//            System.out.println("i : " + i + " " + n + " k : "+ k);
            if(n >= k){
                if(first == 0) first = i;
                digit[i] = n / k;
                n -= k * digit[i];
            }
        }

//        for(var p : digit){
//            System.out.print(p + " ");
//        }
//        System.out.println();

        for(int i = first; i >= 0; i--){
            if(10 <= digit[i] && digit[i] <= 36){
                System.out.print((char)('A' + digit[i] - 10));
            } else{
                System.out.print(digit[i]);
            }
        }


    }
}
