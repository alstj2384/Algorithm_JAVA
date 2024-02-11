package 백준.자바.Strong_Connected_Component_2150;

import java.io.*;
import java.util.*;

public class Main {
    private int V, E, id, sccNum;
    private int[] d;
    private List<List<Integer>> a = new ArrayList<>();
    private List<List<Integer>> SCC = new ArrayList<>();
    private Stack<Integer> s = new Stack<>();
    private boolean[] visited;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        d = new int[V+1];
        visited = new boolean[V+1];

        for(int i = 0; i < V+1; i++){
            a.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            a.get(x).add(y);
        }

        for(int i  = 1; i < V+1; i++){
            if(d[i]==0) dfs(i);
        }

        sb.append(sccNum).append('\n');
        for(var k : SCC){
            Collections.sort(k);
        }
        Collections.sort(SCC, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });

        for(var k : SCC){
            for(var q : k){
                sb.append(q).append(" ");
            }
            sb.append("-1").append("\n");
        }

        System.out.println(sb);
    }

    private int dfs(int x){
        d[x] = ++id;
        s.push(x);

        int result = d[x]; // result = 현재 칸의 id
        Iterator<Integer> it = a.get(x).iterator();
        while(it.hasNext()){
            int next = it.next();
            if(d[next] == 0) result = Math.min(result, dfs(next));
            else if(!visited[next]) result = Math.min(result, d[next]);
        }

        if(result == d[x]){
            List<Integer> scc = new ArrayList<>();
            while(true){
                int t = s.pop();
                scc.add(t);
                visited[t] = true;
                if(t == x) break;
            }
            SCC.add(scc);
            sccNum++;
        }
        return result;
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
