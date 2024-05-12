package SWEA.패턴마디의길이_2007;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String s = br.readLine();
            int pattern = 1;
            int index = 0;
            while (index + pattern <= 29) {
                if (s.charAt(index) == s.charAt(index + pattern)) {
                    index++;
                } else {
                    index = 0;
                    pattern++;
                }
            }
            System.out.println("#"+(i+1)+" " +pattern);
        }
    }
}
