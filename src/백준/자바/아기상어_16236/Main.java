package 백준.자바.아기상어_16236;

import java.io.*;
import java.util.*;

public class Main {
    private int N;
    private boolean[][] visited;
    Shark shark;
    List<Fish> fishes;
    private int[][] map;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private int time;
    // 거리를 계산하는 bfs

    void play(){
        while(true) {
            if (shark.exp == shark.size) {
                shark.size++;
                shark.exp = 0;
            }

            getAllDistance();
            sortByDistance();
            if (eat()) {
                shark.exp++;
            } else {
                System.out.println(time);
                return;
            }
        }
    }

    void display(){
        for(var k : fishes){
            System.out.println("(" + k.x + ","+k.y+")  , dist = " + k.dist);
        }
        System.out.println();
    }

    int bfs(Fish f){
        Queue<Fish> q = new LinkedList<>();

        f.dist = 0;
        q.offer(f);
        while(!q.isEmpty()){
            Fish fish = q.poll();

            if(fish.x == shark.x && fish.y == shark.y) return fish.dist;

            for(int i = 0; i < 4; i++){
                int nx = fish.x + dx[i];
                int ny = fish.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
                if(map[fish.x][fish.y] > shark.size) continue;

                q.offer(new Fish(nx, ny, 0, fish.dist+1));
                visited[nx][ny] = true;
            }
        }
        // 상어 레벨이 물고기 레벨보다 크면 이동 x
        return Integer.MAX_VALUE;
    }

    boolean eat(){
        boolean ate = false;
        for(var k : fishes){
            if(eatable(k.size) && k.dist != Integer.MAX_VALUE) {
                shark.x = k.x;
                shark.y = k.y;
                time += k.dist;
                fishes.remove(k);
                ate = true;
                break;
            }
        }
        return ate ? true : false;
    }


    // 물고기들의 좌표와 현재 위치 기준 거리가 담긴 리스트
    void sortByDistance(){
        Collections.sort(fishes, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                if(o1.dist == o2.dist){
                    if(o1.x == o2.x){
                        return o1.y-o2.y;
                    }
                    else{
                        return o1.x - o2.x;
                    }
                }else{
                    return o1.dist - o2.dist;
                }
            }
        });
    }

    void getAllDistance(){
        for(var k : fishes){
            visited = new boolean[N][N];
            k.dist = bfs(k);
        }
    }

    // 물고기를 먹을 수 있는지 확인하는 메소드
    boolean eatable(int size){
        // 상어 레벨이 물고기 레벨보다 높아야 함
        return shark.size > size;
    }

    class Shark{
        int x;
        int y;
        int size;
        int exp;

        public Shark(int x, int y, int size, int exp) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.exp = exp;
        }
    }
    class Fish{
        int x;
        int y;
        int size;
        int dist;

        public Fish(int x, int y, int size, int dist) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.dist = dist;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        fishes = new ArrayList<>();
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int val = Integer.parseInt(st.nextToken());
                if(val == 9) {
                    shark = new Shark(i, j, 2, 0);
                    map[i][j] = 0;
                }
                else if(val > 0 && val < 7){
                    map[i][j] = val;
                    fishes.add(new Fish(i, j, val, 0));
                }
                else map[i][j] = 0;
            }
        }

        if(fishes.size() == 0){
            System.out.println(0);
        }
        else play();



    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
