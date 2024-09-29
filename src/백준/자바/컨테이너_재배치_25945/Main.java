package 백준.자바.컨테이너_재배치_25945;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Long[] c = new Long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Long M = 0L;
        for(int i = 0; i < N; i++){
            c[i] = Long.parseLong(st.nextToken());
            M += c[i];
        }


        Arrays.sort(c, Collections.reverseOrder());

//        System.out.println(M);
//        for(var p : c){
//            System.out.print(p + " ");
//        }
//        System.out.println();


        long avg = M / N;
        long remainder = M%N;
        long count = 0;

        // avg + 1인 애들을 remainder번 반복하면 되고
        // 그 이후는 avg 이상인 애들을 avg로 정상화

        // avg 이상인 애들 중에서 remainder가 남아있으면 avg+1로 정상화 하고
        // remainder가 없으면 avg로 정상화

        int i = 0;
        while(c[i] > avg){


            if(remainder > 0) {
                count += c[i] - avg -1;
                remainder--;
            }
            else {
                count += c[i] - avg;

            }
            i++;
        }
        System.out.println(count);


    }
}
