package 백준.자바.접미사배열_11656;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();


        List<String> arr = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            arr.add(s.substring(i));
        }

        Collections.sort(arr);

        for(String k : arr){
            System.out.println(k);
        }
    }
}
