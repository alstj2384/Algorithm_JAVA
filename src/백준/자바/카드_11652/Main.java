package 백준.자바.카드_11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            long k = Long.parseLong(br.readLine());
            if(map.get(k) == null){
                map.put(k, 1);
            } else{
                map.put(k, map.get(k)+1);
            }
        }

        int maxCount = 0;
        long maxVal = 0;
        for(long v : map.keySet()){
            if(map.get(v) > maxCount){
                maxVal = v;
                maxCount = map.get(v);
            } else if(map.get(v) == maxCount){
                if(v < maxVal)
                    maxVal = v;
            }
        }
        System.out.println(maxVal);
    }
}
