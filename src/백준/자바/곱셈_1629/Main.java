package 백준.자바.곱셈_1629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A, B, C;

    static long mul(long b){
        if(b == 1) return A % C;
        long temp = mul(b / 2);

        if(b % 2 == 1){
            return ((temp * temp) % C * A) % C;
        }
        return temp * temp % C;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(mul(B));
    }
}
