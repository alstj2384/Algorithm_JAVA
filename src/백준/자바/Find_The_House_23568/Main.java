package 백준.자바.Find_The_House_23568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            int c = Integer.parseInt(st.nextToken());

            if(b.equals("R")){
                map.put(a, c);
            } else{
                map.put(a, -c);
            }
        }

        int cur = Integer.parseInt(br.readLine());

        while(map.containsKey(cur)) {
            cur += map.get(cur);
        }

        System.out.println(cur);
    }
}
