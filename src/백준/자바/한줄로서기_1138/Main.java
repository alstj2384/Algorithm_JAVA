package 백준.자바.한줄로서기_1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];

        for(int i = 1; i < n+1; i++){
            int k = Integer.parseInt(st.nextToken());


            int index = 0;

            while (arr[index] != 0) {
                index += 1;
            }


            for(int j = 0; j < k; j++) {
                index+= 1;

                while (arr[index] != 0) {
                    index += 1;
                }
            }

            arr[index] = i;
        }
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
