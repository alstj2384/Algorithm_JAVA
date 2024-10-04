package 백준.자바.주차_빌딩_3699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_H = 50;
    public static final int MAX_L = 50;
    public static int[][] map;
    public static int h, l;

    public static void move(int[] row, int count){
        int[] tmpRow = new int[MAX_L];
        // count > 0 : 오른쪽 이동
        // count < 0 : 왼쪽 이동
        for(int i = 0; i < l; i++){
            int index = (l + i + count) % l;
            tmpRow[index] = row[i];
        }
        for(int i= 0 ; i < l; i++) {
            row[i] = tmpRow[i];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            map = new int[MAX_H][MAX_L];
            StringTokenizer st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            for(int i = 0 ; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < l; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int turn = 1, move = 0, time = 0;
            while(true) {
                boolean isFound = false;
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < l; j++) {
                        if (map[i][j] == turn) {
                            turn += 1;
                            move = l - j < j ? l - j : -j;
                            move(map[i], move);

                            time += 20 * i + 5 * Math.abs(move);
                            isFound = true;
                            break;
                        }
                    }
                    if (isFound) break;
                }
                if(!isFound) break;
            }
            System.out.println(time);

        }

    }
}
