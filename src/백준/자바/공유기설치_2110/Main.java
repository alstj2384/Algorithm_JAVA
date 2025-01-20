package 백준.자바.공유기설치_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean check(int x){
        int remainHome = C-1;
        int last = home[1];
        for(int i = 2; i < N+1; i++){
            if(home[i] - last >= x){
                remainHome -= 1;
                last = home[i];
            }
            if(remainHome == 0){
                return true;
            }
        }
        return false;
    }
    static int N, C;
    static int[] home;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        home = new int[N+1]; // 1 ~ 200,000

        for(int i = 1; i < N+1; i++){
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int lo = 1; // T
        int hi = 1_000_000_001; // F

        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            boolean b = check(mid);
            if(b){
                lo = mid;
            } else{
                hi = mid;
            }
        }

        System.out.println(lo);


    }
}
