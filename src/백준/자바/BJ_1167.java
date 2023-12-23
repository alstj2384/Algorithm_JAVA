package 백준.자바;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1167 {
    static Vector<HashMap<Integer, Integer>> v = new Vector<>();
    static Vector<Integer> result = new Vector<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k+1; i++)
            v.add(new HashMap<Integer, Integer>());

        for(int i = 0; i < k; i++){
            var st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int token = 0;

            while(true) {
                int vertex = Integer.parseInt(st.nextToken());
                if(vertex == -1)
                    break;
                int dist = Integer.parseInt(st.nextToken());
                v.get(idx).put(vertex, dist);
            }
        }
        Vector<Integer> leaf = new Vector<>();
        for(int i =1; i < k+1; i++){
            if(v.get(i).size() == 1){
                leaf.add(i);
            }
        }

        for(int i = 0; i < leaf.size();i++){
            visited = new boolean[k+1];
            DFS(leaf.get(i), 0);
        }
        System.out.println(Collections.max(result));

    }
    public static void DFS(int i, int dist){
        var sets = v.get(i).entrySet();
        if (!visited[i]){
            visited[i] = true;
            for(var s : sets){
                if(!visited[s.getKey()]) {
                    DFS(s.getKey(), dist + s.getValue());
                }
            }
        }
        if(v.get(i).size() == 1) {
            result.add(dist);
        }
    }

}
