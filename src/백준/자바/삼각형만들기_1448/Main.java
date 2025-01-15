package 백준.자바.삼각형만들기_1448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());

        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < N-2; i++){
            if(list.get(i) < list.get(i+1) + list.get(i+2)){
                sum = list.get(i) + list.get(i+1) + list.get(i+2);
                break;
            }
        }

        System.out.println(sum == Integer.MIN_VALUE ? -1 : sum);
    }
}
