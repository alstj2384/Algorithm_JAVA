package 백준.자바.FlymeTotheAlphaCentauri_1011;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dist = -(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));

            if(dist == 1) {
                System.out.println(1);
                continue;
            }
            int a = (int)Math.sqrt(dist);
            if(a == Math.sqrt(dist)){
                System.out.println(a*2-1);
                continue;
            }
            if(a*a+a < dist){
                System.out.println(a*2+1);
            } else{
                System.out.println(a*2);
            }

        }
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
