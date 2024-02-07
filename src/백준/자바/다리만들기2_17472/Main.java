package 백준.자바.다리만들기2_17472;

import java.io.*;
import java.util.*;

public class Main {
    /**
     * 1. dfs를 활용해 섬들에 번호 붙이기
     * 2. 각 섬의 모든 좌표에서 섬인경우, 상, 하, 좌, 우 방향으로 다른 섬과 연결되는지 보고
     *    연결 될 경우 간선 정보를 저장(s, e, dist)
     * 3. 생성한 간선을 정렬 후, kruskal 알고리즘 실행(union-find 구현 필요)
     * 4. parent의 find가 모두 같은 값이면, 연결에 성공한 것,
     */
    // map 정보
    private int N, M;
    private int[][] map;


    // 1을 위한 변수 및 함수
    private boolean[][] visited;
    private int islandCount, nx, ny;
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};

    private boolean dfs(int x, int y){
        if(visited[x][y] || map[x][y] == 0) return false;
        visited[x][y] = true;

        for(int i =0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >=  M) continue;
            if(map[nx][ny] == 1) dfs(nx, ny);
        }

        map[x][y] = islandCount;
        return true;
    }

    // 2를 위한 변수 및 함수
    List<Edge> edges = new ArrayList<>();
    private void check(int x, int y){
        if(map[x][y] == 0) return;
        int startIsland = map[x][y];
        for(int i = 0; i < 4; i++){
            int count = 0;
            nx = x; ny = y;
            // 굳이 상관 없는 건데, 간선의 중복을 막기 위해 visited사용 고려.. 근데 지금은 안함
            while(true){
                count++;
                nx = nx + dx[i];
                ny = ny + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
                if(map[nx][ny] == startIsland) break;
                if(map[nx][ny] != 0){
                    // 다른 섬을 만난 경우
                    if(count > 2 && !visited[nx][ny])
                        edges.add(new Edge(startIsland, map[nx][ny], count-1));
                    break;
                }
            }
        }
        visited[x][y] = true;
    }

    class Edge{
        int start;
        int end;
        int dist;

        public Edge(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }


    // 3을 위한 변수 및 함수
    private int[] parent;
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

    // 4를 위한 함수 및 변수
    private boolean isAllLinked(){
        int x = find(1);
        for(int i = 2; i < islandCount+1; i++){
            if(x != find(i)) return false;
        }
        return true;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1 모든 좌표에 대해서 dfs 수행(번호 매기기)
        islandCount = 1;
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(dfs(i, j)) islandCount++;
            }
        }
        islandCount--;

        // 2. 모든 좌표에서 이어질 수 있는 경로 및 거리 탐색
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                check(i, j);
            }
        }

        // 3. 간선 정렬 및 크루스칼 알고리즘 수행
        int cost = 0; // 비용 저장을 위한 변수
        parent = new int[islandCount+1];
        for(int i= 0; i < islandCount+1; i++){
            parent[i] = i;
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist-o2.dist;
            }
        });

        // 크루스칼 알고리즘 수행
        for(int i = 0; i < edges.size(); i++){
            int start = edges.get(i).start;
            int end = edges.get(i).end;

            if(find(start) != find(end)){
                union(start, end);
                cost += edges.get(i).dist;
            }
        }

        // 4 parent의 모든 부모가 같으면 모두 연결된 것, or -1
        System.out.println(isAllLinked() ? cost : -1);

    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
