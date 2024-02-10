package 백준.자바.너의평점은_25206;

import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double sum = 0;
        int total = 0;
        for(int i = 0; i < 20; i++){
            st = new StringTokenizer(br.readLine());
            String s= st.nextToken();
            double d = Double.parseDouble(st.nextToken());
            s = st.nextToken();
            total += d;
            switch(s){
                case "A+": sum += 4.5*d; break;
                case "A0": sum += 4.0*d; break;
                case "B+": sum += 3.5*d; break;
                case "B0": sum += 3.0*d; break;
                case "C+": sum += 2.5*d; break;
                case "C0": sum += 2.0*d; break;
                case "D+": sum += 1.5*d; break;
                case "D0": sum += 1.0*d; break;
                case "F": break;
                case "P": total -= d; break;
            }
        }
        if(sum == 0) System.out.printf("%.6f", 0.000000);
        else System.out.printf("%.6f", sum/total);

    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
