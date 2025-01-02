package 백준.자바.경비원_2564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r, c;
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int v = Integer.parseInt(br.readLine());
        int[][] pos = new int[v+1][2];

        for(int i = 1; i < v+1; i++){
            st = new StringTokenizer(br.readLine());

            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        pos[0][0] = Integer.parseInt(st.nextToken());
        pos[0][1] = Integer.parseInt(st.nextToken());

        int dist = 0;

        for(int i = 1; i < v+1; i++){
            int before = dist;
            if((pos[0][0] == 1 && pos[i][0] == 3) || (pos[0][0] == 3 && pos[i][0] == 1)){
                // 북서(1, 3)
                // 1의 거리 + 2의 거리
                dist += pos[0][1] + pos[i][1];

            } else if((pos[0][0] == 1 && pos[i][0] == 2) || (pos[0][0] == 2 && pos[i][0] == 1)){
                // 북남(1, 2)
                // Math.min(1의 거리 + 2의 거리 + R, (C-1의거리 + C-2의거리 + R)
                dist += Math.min(pos[0][1] + pos[i][1], (c-pos[0][1] + c-pos[i][1])) + r;
            }  else if((pos[0][0] == 1 && pos[i][0] == 4) || (pos[0][0] == 4 && pos[i][0] == 1)){
                // 북동(1, 4)
                // (C-1의거리) + 2의 거리
                dist += (c - pos[0][1]) + pos[i][1];

            } else if((pos[0][0] == 3 && pos[i][0] == 4) || (pos[0][0] == 4 && pos[i][0] == 3)){
                // 서동(3, 4)
                // Math.min(1의 거리 + 2의 거리 + C, (R-1의거리 + R-2의 거리 + C)
                dist += Math.min(pos[0][1] + pos[i][1], r-pos[0][1] + r-pos[i][1]) + c;
            } else if((pos[0][0] == 2 && pos[i][0] == 3) || (pos[0][0] == 3 && pos[i][0] == 2)){
                // 서남(3, 2)
                // (R-1의거리 + 2의 거리)
                dist += r-pos[0][1] + pos[i][1];

            } else if((pos[0][0] == 2 && pos[i][0] == 4) || (pos[0][0] == 4 && pos[i][0] == 2)){
                // 동남(4, 2)
                // (R-1의거리) + (C-2의거리)
                dist += r-pos[0][1] + c-pos[i][1];
            } else{
                // 같은 방향
                dist += Math.abs(pos[0][1] - pos[i][1]);
            }
            System.out.println(dist - before);

        }
        System.out.println(dist);
        // start = d, d1, end = d, d2





    }
}
