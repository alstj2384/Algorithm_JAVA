package 백준.자바.예산_2512;

import java.io.*;
import java.util.*;

public class Main {
    private int avr;
    private int m, n;
    private Vector<Integer> v = new Vector<>();
    int at;
    void dfs(){
        if(at >= n) {
            avr = v.lastElement();
            return;
        }
        if(v.get(at) <= avr){
            m -= v.get(at);
            at++;
            dfs();
        } else{
            avr = m/(n-at);
            if(v.get(at) <= avr) dfs();
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) v.add(Integer.parseInt(st.nextToken()));
        m = Integer.parseInt(br.readLine());

        Collections.sort(v);

        avr = m/n;
        dfs();
        System.out.println(avr);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
