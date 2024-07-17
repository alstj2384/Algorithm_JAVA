package 백준.자바.신나는함수실행_9184;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][][] cache;

    static int w(int a, int b, int c){
        if(inRange(a, b, c) && cache[a][b][c] != -1){
            return cache[a][b][c];
        }
        if(a <= 0 || b <= 0 || c <= 0)
            return 1;
        if(a > 20 || b > 20 || c > 20)
            return cache[20][20][20] = w(20, 20, 20);


        if(a < b && b < c)
            return cache[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        return cache[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    static boolean inRange(int a, int b, int c){
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a, b, c;

        StringBuilder sb = new StringBuilder();

        cache = new int[21][21][21];
        for(int i = 0; i < 21; i++){
            for(int j = 0; j < 21; j++){
                Arrays.fill(cache[i][j], -1);
            }
        }

        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) break;

            int val = w(a, b, c);
            sb.append("w(" + a + ", " + b + ", " + c + ") = " + val + "\n");
        }
        System.out.print(sb);
    }
}
