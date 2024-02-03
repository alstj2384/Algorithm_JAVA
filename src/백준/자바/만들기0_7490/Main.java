package 백준.자바.만들기0_7490;

import java.io.*;
import java.util.*;

public class Main {
    private int k, t;
    private StringBuilder sb = new StringBuilder();

    void dfs(int x, String s){
        if(x >= t){
            s = s+x;
            // x가 t보다 커지면 -> t가 3이고, x가 1,2,3을 수행 후 4가 되면..
            String tmp = s.replaceAll(" ", "");
            String[] nums = tmp.split("[+,-]");

            String[] opers = new String[nums.length-1];

            for(int idx = 0, i = 0; i < tmp.length(); i++){
                if(tmp.charAt(i) == '-')
                    opers[idx++] = "-";
                if(tmp.charAt(i) == '+')
                    opers[idx++] = "+";
            }


            int sum = 0;
            sum = Integer.parseInt(nums[0]);
            for(int i = 0; i < opers.length; i++){
                if(opers[i].equals("+")) sum += Integer.parseInt(nums[i+1]);
                if(opers[i].equals("-")) sum -= Integer.parseInt(nums[i+1]);
            }

            if(sum == 0)
                sb.append(s).append('\n');
            return;
        }
        dfs(x+1,s+x+' ');
        dfs(x+1, s+x+'+');
        dfs(x+1,s+x+'-');


    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++){
            t = Integer.parseInt(br.readLine());
            sb=  new StringBuilder();
            dfs(1,"");
            System.out.println(sb);
        }
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
