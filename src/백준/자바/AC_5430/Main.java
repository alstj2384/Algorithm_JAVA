package 백준.자바.AC_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void call(){
        boolean R = true;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == 'R') R = !R;
            else{
                if(d.size() == 0) {
                    System.out.println("error");
                    return;
                }
                if(R) d.pollFirst();
                else d.pollLast();
            }
        }
        StringBuilder sb = new StringBuilder("[");
        while(!d.isEmpty()){
            if(R){
                sb.append(d.pollFirst());
            } else{
                sb.append(d.pollLast());
            }
            if(!d.isEmpty()){
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
    static String s;
    static Deque<String> d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T > 0){

            s = br.readLine();
            int k = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            // true = 정방향, false = 역방향

            if(!arr.equals("[]")) {
                d = new LinkedList<>(List.of(arr.substring(1, arr.length() - 1).split(",")));
            } else{
                d = new LinkedList<>();
            }
            call();
//            d.forEach(System.out::println);

            T--;
        }




    }
}
