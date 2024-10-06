package 백준.자바.CommemorativeDice_20170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dice1 = new int[6];
        for(int i  =0; i < 6; i++){
            dice1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] dice2 = new int[6];
        for(int i  =0; i < 6; i++){
            dice2[i] = Integer.parseInt(st.nextToken());
        }

        int winCount = 0;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(dice1[i] > dice2[j]) winCount+=1;
            }
        }

        int total = 36;
        for(int i = 36; i >= 2; i--){
            if(total % i == 0 && winCount % i == 0){
                total /= i;
                winCount /= i;
            }
        }
        System.out.println(winCount + "/" + total);

    }
}
