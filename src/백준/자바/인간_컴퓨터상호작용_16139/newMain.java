package 백준.자바.인간_컴퓨터상호작용_16139;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class newMain {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());

        int[][] alp = new int[26][S.length()+1];

        for(int i = 1; i < S.length()+1; i++){
            char c = S.charAt(i-1);
            for(int j = 0; j < 26; j++){
                if(c - 'a' == j){
                    alp[j][i] = alp[j][i-1] + 1;
                } else
                    alp[j][i] = alp[j][i-1];
            }
        }

        for(int i = 0; i < q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            char c = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) + 1;

            sb.append(alp[c-'a'][b] - alp[c-'a'][a]).append('\n');
        }
        System.out.print(sb);
    }
}
