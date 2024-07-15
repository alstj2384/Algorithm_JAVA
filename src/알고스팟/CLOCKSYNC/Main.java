package 알고스팟.CLOCKSYNC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] clocks, availableSwitches;
    static int[][] clockToSwitch = {
            {0, 3, 5}, {0, 8}, {0, 5, 8}, {1, 6, 8, 9},
            {2, 3, 7, 8, 9}, {3, 7, 8, 9}, {3, 4}, {1, 3, 4, 7},
            {4}, {1, 9}, {2, 4}, {1}, {4}, {9}, {2, 5, 6, 7}, {2, 5, 7}
    };
    static int[][] switches = {
            {0, 1, 2}, {3, 7, 9, 11}, {4, 10, 14, 15}, {0, 4, 5, 6, 7},
            {6, 7, 8, 10, 12}, {0, 2, 14, 15}, {3, 14, 15}, {4, 5, 7, 14, 15},
            {1, 2, 3, 4, 5}, {3, 4, 5, 9, 13}
    };

    static boolean[] disable;
    static int val;

    static void dfs(){
        while(true){
            int clockIndex = -1;
            int k = 0;
            for(int i = 0; i < 16; i++){
                if(availableSwitches[i] == 1){
                    clockIndex = i;
                    break;
                }
            }
            if(clockIndex == -1) return;

            for(int i = 0; i < clockToSwitch[clockIndex].length; i++){
                k = clockToSwitch[clockIndex][i];
                if(!disable[k]){
                    disable[k] = true;
                    rotateClocks(clockIndex, k);
                    break;
                }
            }

            for(int i = 0; i < 16; i++){
                for(int j = 0; j < clockToSwitch[i].length; j++){
                    if(clockToSwitch[i][j] == k){
                        availableSwitches[i]--;
                    }
                }
            }
        }

        // rotate clocks
    }

    static void rotateClocks(int clockIndex, int switchNum){
        while(clocks[clockIndex] != 12){
            val += 1;
            for(int i = 0; i < switches[switchNum].length; i++){
                int k = switches[switchNum][i];
                clocks[k] += 3;
                if(clocks[switches[switchNum][i]] == 15) clocks[k] = 3;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        for(int test = 0; test < C; test++){
            clocks = new int[16];
            availableSwitches = new int[]{
                    3, 2, 3, 4, 5, 4, 2, 4, 1, 2, 2, 1, 1, 1, 4, 3
            };

            disable = new boolean[10];

            val = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 16; i++){
                clocks[i] = Integer.parseInt(st.nextToken());
            }

            dfs();
            System.out.println(val);


        }
    }
}
