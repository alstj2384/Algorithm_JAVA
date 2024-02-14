package 백준.자바.음식평론가_1188;
import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        int a, b;

        a = sc.nextInt();
        b = sc.nextInt();

        System.out.println(b-gcd(a,b));

    }

    private int gcd(int p, int q){
        return p%q == 0 ? q : gcd(q, p%q);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
