package 백준.자바.민호와강호_11662;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        double Ax, Ay, Bx, By, Cx, Cy, Dx, Dy;
        Ax = Integer.parseInt(st.nextToken());
        Ay = Integer.parseInt(st.nextToken());
        Bx = Integer.parseInt(st.nextToken());
        By = Integer.parseInt(st.nextToken());
        Cx = Integer.parseInt(st.nextToken());
        Cy = Integer.parseInt(st.nextToken());
        Dx = Integer.parseInt(st.nextToken());
        Dy = Integer.parseInt(st.nextToken());


        int interval = 1000000;
        double aDX = (Bx - Ax) / interval;
        double aDY = (By - Ay) / interval;
        double cDX = (Dx - Cx) / interval;
        double cDY = (Dy - Cy) / interval;

        double min = getDistance(Ax, Ay, Cx, Cy);

        for(int i = 1; i <= interval; i++){
            double tmp = getDistance(Ax + aDX*i, Ay + aDY*i, Cx + cDX*i, Cy + cDY*i);

            if(tmp < min) min = tmp;
        }
        System.out.println(min);
    }
    static double getDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1,2));
    }
}
