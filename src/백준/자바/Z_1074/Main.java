package 백준.자바.Z_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int count;
    static boolean inRange(int row, int col, int val){
        return R >= row && R < row+val && C >= col && C < col+val;
    }
    static boolean isFinished = false;
//    static void dfs(int r, int c, int n){
//        if(isFinished) return;
//        System.out.println(r + " " + c);
//        if(r == R && c == C){
//            System.out.println(count);
//            isFinished = true;
//            return;
//        }
//        if(n == 0) {
//            count += 1;
//            return;
//        }
//        int val = (int)Math.pow(2, n-1);
//        dfs(r,c,n-1);
//        dfs(r, c+val,n-1);
//        dfs(r+val, c, n-1);
//        dfs(r+val, c+val, n-1);
//    }
    static void dfs(int r, int c, int n){
        if(r == R && c == C){
            System.out.println(count);
            return;
        }
        if(n == 0) {
            return;
        }
        int val = (int)Math.pow(2, n-1);

        if(inRange(r, c, val)){
            dfs(r,c,n-1);
        } else if(inRange(r, c+val, val)){
            count += val * val;
            dfs(r, c+val,n-1);

        } else if(inRange(r+val, c, val)){
            count += val * val * 2;
            dfs(r+val, c, n-1);
        } else {
            count += val * val * 3;
            dfs(r+val, c+val, n-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dfs(0, 0, N);

    }
}
