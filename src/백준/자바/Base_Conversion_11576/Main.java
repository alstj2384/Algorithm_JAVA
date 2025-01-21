package 백준.자바.Base_Conversion_11576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        int[] Aarr = new int[26];
        int[] Barr = new int[26];

        st = new StringTokenizer(br.readLine());

        int i = m;
        while(--i >= 0){
            Aarr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(i = 0; i < m; i++){
            sum += Math.pow(A, i) * Aarr[i];
        }

        int BFirst = 0;
        for(i = 26; i >= 0; i--) {
            int val = (int)Math.pow(B, i);
            if(val <= sum){
                if(BFirst == 0) BFirst = i;
                Barr[i] = sum / val;
                sum -= Barr[i] * val;
            }
        }
        for(i = BFirst; i >= 0; i--){
            System.out.print(Barr[i] + " ");
        }
    }
}
