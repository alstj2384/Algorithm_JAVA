package 백준.자바.SportClimbingCombined;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Person implements Comparable<Person>{
        int number;
        int p, q, r;

        public Person(int number, int p, int q, int r) {
            this.number = number;
            this.p = p;
            this.q = q;
            this.r = r;
        }

        @Override
        public int compareTo(Person o) {
            // 곱으로 결정
            if(p*q*r != o.p*o.q*o.r){
                return p*q*r - o.p*o.q*o.r;
            } else if(p + q + r != o.p + o.q + o.r){
                return (p + q + r) - (o.p + o.q + o.r);
            } else{
                return number - o.number;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Person> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0;i  < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            list.add(new Person(num, p, q,r));
        }

        Collections.sort(list);

        System.out.println(list.get(0).number + " " + list.get(1).number + " " + list.get(2).number);
    }
}
