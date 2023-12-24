package 백준.자바.베스트셀러_1302;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(rd.readLine());
        Map<String, Integer> m = new TreeMap<>();
        String s = "";
        for(int i = 0; i < n; i++) {
            s = rd.readLine();
            if (m.get(s) == null) m.put(s, 1);
            else m.put(s, m.get(s) + 1);
        }
        int tmp = 0;
        for(var k : m.keySet())
            if(m.get(k) > tmp){
                tmp = m.get(k);
                s = k;
            }

        System.out.println(s);
    }
}

