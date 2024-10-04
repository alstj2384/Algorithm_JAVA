package 백준.자바.Parentheses_Tree_26111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String s = br.readLine();

        // 1. depth = 0, (를 만나면 +1, )를 만났을때 앞이 (이면 depth만큼 dist += depth -> depth -1;
        long dist = 0L;
        int depth = 0;

        // 1번째는 무조건 ( 임
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);

            if('(' == c){
                depth += 1;
            }
            if(')' == c){
                // 여기서 앞이 ( 이면 depth만큼 += 1;
                if(s.charAt(i-1) == '('){
                    dist += depth;
                }
                depth -= 1;
            }
//            System.out.println(i + " 번째 depth = " + depth + " dist = " + dist);
        }

        System.out.println(dist);

    }
}
