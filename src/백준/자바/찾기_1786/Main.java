package 백준.자바.찾기_1786;

import java.io.*;
import java.util.*;

public class Main {
    private int[] pi;
    private int answer;
    private List<Integer> list = new ArrayList<>();
    private String s, p;

    void getPi(){
        int j = 0;
        pi = new int[p.length()];

        for(int k = 1; k < p.length(); k++){
            while(p.charAt(k) != p.charAt(j) && j > 0){
                j = pi[j-1];
            }
            if(p.charAt(k) == p.charAt(j)){
                pi[k] = ++j;
            }
        }
    }

    void kmp() {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                if (j == p.length() - 1) {
                    answer++;
                    list.add(i - j + 1);
                    j = pi[j];
                } else j++;
            }
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        p = br.readLine();

        getPi();
        kmp();
        StringBuilder sb = new StringBuilder();

        sb.append(answer).append('\n');
        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }

        for (int i : pi) {
            System.out.print(i + " ");

        }
        System.out.println("----");
        System.out.print(sb);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
