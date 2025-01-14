package 백준.자바.제로_10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();

        while(K > 0){
            int k = Integer.parseInt(br.readLine());

            if(k != 0){
                s.push(k);
            } else
                s.pop();
            K--;
        }

        int sum = 0;
        while(!s.isEmpty()){
            sum += s.pop();
        }

        System.out.println(sum);

    }
}
