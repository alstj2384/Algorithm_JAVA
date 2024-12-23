package 백준.자바.수띄어쓰기_1748;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long i = sc.nextInt();
        long count = 0L;
        int len = String.valueOf(i).length()-1;

        while(len >= 0){
            long p = (int)Math.pow(10, len) ;

            long diff = i - p + 1;
            count += diff * (len+1);
            i -= diff;
            len -= 1;
        }

        System.out.println(count);
    }
}
