package 백준.자바.친구네트워크_4195;
import java.io.*;
import java.util.*;

public class Main {
    private int[] parent, friends;
    private void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x != y){
            parent[y] = x;
        }
    }

    private int find(int x){
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            Map<String, Integer> map = new HashMap<>();


            int k = 0;
            int F = Integer.parseInt(br.readLine());
            parent = new int[Math.min(200001, F*2+2)];
            friends = new int[Math.min(200001, F*2+2)];

            Arrays.fill(friends, 1);
            for(int j = 1; j < parent.length; j++){
                parent[j] = j;
            }

            for(int j = 0; j < F; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String left = st.nextToken();
                String right = st.nextToken();

                if(map.get(left) == null){
                    map.put(left, ++k);
                }
                if(map.get(right) == null){
                    map.put(right, ++k);
                }
                if(find(map.get(left)) != find(map.get(right))){
                    friends[find(map.get(left))] = friends[find(map.get(left))] + friends[find(map.get(right))];
                    union(map.get(left), map.get(right));
                    sb.append(friends[find(map.get(left))]).append('\n');
                }
                else{
                    sb.append(friends[find(map.get(left))]).append('\n');
                }
            }
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
