package 백준.자바.벡터매칭_1007;
import java.io.*;
import java.util.*;

public class Main {
    private boolean[] visited;
    private int n;
    List<Pair> v;
    private double result;
    private void dfs(int index, int count){
        if(count == 0)
            result = Math.min(result, getVector());
        else{
            for(int i = index; i < n; i++){
                visited[i] = true;
                dfs(i+1, count-1);
                visited[i] = false;
            }
        }
    }

    private double getVector(){
        int x = 0;
        int y = 0;

        for(int i = 0; i < n; i++){
            if(visited[i]){
                x += v.get(i).x;
                y += v.get(i).y;
            }
            else {
                x -= v.get(i).x;
                y -= v.get(i).y;
            }
        }
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y,2));
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int k = 0; k  < T; k++){
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n];
            v = new ArrayList<>();
            result = Double.MAX_VALUE;

            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                v.add(new Pair(x, y));
            }

            dfs(0, n/2);
            System.out.println(result);
        }


    }


    class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}