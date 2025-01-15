package 백준.자바.빈도정렬_2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Freq implements Comparable<Freq>{
        int freq, prior, val;

        public Freq(int freq, int prior, int val){
            this.freq = freq;
            this.prior = prior;
            this.val = val;
        }

        public void plusFreq(){
            freq+=1;
        }
        public int compareTo(Freq o1){
            if(freq == o1.freq){
                return prior - o1.prior;
            }
            return o1.freq - freq;
        }

        public String toString(){
            return "freq: " + freq + " prior: " + prior + " val:" + val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Freq> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int k = Integer.parseInt(st.nextToken());

            Freq freq = map.get(k);
            if(freq == null){
                map.put(k, new Freq(1, i, k));
            } else{
                freq.plusFreq();
            }
        }

        List<Freq> list = new ArrayList<Freq>(map.values());
        Collections.sort(list);

//        list.forEach(System.out::println);

        for(var p : list){
            for(int i = 0; i < p.freq; i++){
                System.out.print(p.val+ " ");
            }
        }
    }
}
