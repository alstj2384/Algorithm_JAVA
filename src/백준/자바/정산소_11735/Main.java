package 백준.자바.정산소_11735;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N, T;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<String, Integer>();

        int k = N;

        long startMax = 0;
        while(k > 0){
            startMax += k;
            k--;
        }

        long RM, CM;
        RM = CM = startMax;

        int RE, CE;
        RE = CE = 0;

        for(int test = 0 ; test < T; test++){
            st = new StringTokenizer(br.readLine());

            String rc = st.nextToken();
            long val = Long.parseLong(st.nextToken());

            if(map.containsKey(rc + " " + val)){
                sb.append("0\n");
                continue;
            }
            map.put(rc + " " + val, 1);



            if(rc.equals("R")){
                sb.append(RM + val * (N-CE)).append('\n');
                CM -= val;
                RE += 1;
            }
            else{
                sb.append(CM + val * (N-RE)).append('\n');
                RM -= val;
                CE += 1;
            }

        }
        System.out.print(sb);

    }
}
