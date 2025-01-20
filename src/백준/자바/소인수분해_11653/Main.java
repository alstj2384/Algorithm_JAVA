package 백준.자바.소인수분해_11653;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static void pf(int x){
        if(x == 1) return;
        for(int i = 2; i < x+1; i++){
            if(x % i == 0){
                list.add(i);
                pf(x / i);
                return;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        pf(n);

        for(var k: list){
            System.out.println(k);
        }

    }
}
