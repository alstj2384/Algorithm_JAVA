package 백준.자바.큰수만들기_16496;

import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });


        StringBuilder sb = new StringBuilder();
        for(var k : arr){
            sb.append(k);
        }
        if(sb.charAt(0) == '0') System.out.println(0);
        else System.out.println(sb);
        br.close();
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
