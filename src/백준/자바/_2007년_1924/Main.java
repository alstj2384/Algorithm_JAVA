package 백준.자바._2007년_1924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] month = {0, 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 1월 8일 ->
        // 1/2 화 1/3 수 1/4목 1/5금 1/6토 1/7일 1/8월
        // 1월 1일 기준으로 일단위로 바꾸고 일 % 7을 한 값이 1이면, 월요일
        // 0 일, 1 월, 2 화, 3 수, 4 목, 5 금, 6 토, 7 일
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int days = 0;
        while(m > 0){
            days += month[m];
            m--;
        }

        days += d;

        switch(days%7){
            case 0:
                System.out.println("SUN");
                break;
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TUE");
                break;
            case 3:
                System.out.println("WED");
                break;
            case 4:
                System.out.println("THU");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
        }
    }
}
