package 백준.자바.Grave_10378;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // 왼쪽 전체
        // 오른쪽 전체
        // 위쪽 전체
        // 아래쪽 전체

        boolean isPossible = false;
//        if((x3 - x1 >= x && y2 - y1 >= y) || (x3 - x1 >= y && y2-y1 >= x)) {
        if((x3 - x1 >= x && y2 - y1 >= y)) {
//            System.out.println(1);
            isPossible = true;
        }
        if((x2 - x1 >= x && y2 - y4 >= y)) {
//            System.out.println(2);
            isPossible = true;
        }
        if((x2 - x4 >= x && y2 - y1 >= y)) {
//            System.out.println(3);
            isPossible = true;
        }
        if((x2 - x1 >= x && y3 - y1 >= y)) {
//            System.out.println(4);
            isPossible = true;
        }

        System.out.println(isPossible ? "Yes" : "No");





    }
}
