package 백준.자바.문자열분석_10820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;

        while((s = br.readLine()) != null){
            int up = 0;
            int lo = 0;
            int num = 0;
            int space= 0 ;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);

                if(c >= 'A' && c <= 'Z') up += 1;
                else if(c >= 'a' && c <= 'z') lo += 1;
                else if(c >= '0' && c <= '9') num += 1;
                else space += 1;
            }

            System.out.println(lo + " " + up + " " + num + " " + space);
        }


    }
}
