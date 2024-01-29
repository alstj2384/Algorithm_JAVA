package 백준.자바.Easy2048_12100;

import java.io.*;
import java.util.*;

public class Main {
    private int N;
    private int[] putPos;

    class Update{
        int index;
        int val;
        public Update(int i, int v){
            index = i;
            val = v;
        }
    }
    class Pair{
        int x;
        int y;
        int val;

        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    Queue<Update> q = new LinkedList<>();
    void sortEachDirections(List<Pair> list, int vec){
        // 0 = 상, 1 = 하, 2 = 좌, 3 = 우
        switch(vec){
            case 0 : Collections.sort(list, ((o1, o2) -> o1.y == o2.y ? o1.x-o2.x : o1.y - o2.y)); break; // 맞음
            case 1 : Collections.sort(list, ((o1, o2) -> o1.y == o2.y ? o2.x-o1.x : o1.y - o2.y)); break; // 맞음
            case 2 : Collections.sort(list, ((o1, o2) -> o1.x == o2.x ? o1.y-o2.y : o1.x - o2.x)); break; // 맞음
            case 3 : Collections.sort(list, ((o1, o2) -> o1.x == o2.x ? o2.y-o1.y : o1.x - o2.x)); break; // 맞음
        }
        // 각각 방향에 맞게 정렬
    }
    List<Pair> push(List<Pair> list, int vec){
        int fillNum;
        if(vec == 0 || vec == 2) fillNum = 0;
        else fillNum = N-1;
        Arrays.fill(putPos, fillNum);

        List<Pair> newList = new ArrayList<>();
        q.clear();
        int newListSize = 1;
        Pair init = list.get(0);
        boolean isMerged = false;

        if(vec == 0) {
            newList.add(new Pair(putPos[init.y]++, init.y, init.val));
            for (int i = 1; i < list.size(); i++) {
                Pair p = list.get(i);
                if (p.val == newList.get(newListSize - 1).val && p.y == newList.get(newListSize - 1).y && !isMerged ) {
                        q.offer(new Update(newListSize - 1, p.val * 2));
                        isMerged = true;
                } else {
                    newList.add(new Pair(putPos[p.y]++, p.y, p.val));
                    newListSize++;
                    isMerged = false;
                }
            }
        }

        if(vec == 1) {
            newList.add(new Pair(putPos[init.y]--, init.y, init.val));
            for (int i = 1; i < list.size(); i++) {
                Pair p = list.get(i);
                if (p.val == newList.get(newListSize - 1).val && p.y == newList.get(newListSize - 1).y && !isMerged ) {
                    q.offer(new Update(newListSize - 1, p.val * 2));
                    isMerged = true;
                } else {
                    newList.add(new Pair(putPos[p.y]--, p.y, p.val));
                    newListSize++;
                    isMerged = false;
                }
            }
        }

        if(vec == 2) {
            newList.add(new Pair(init.x, putPos[init.x]++, init.val));
            for (int i = 1; i < list.size(); i++) {
                Pair p = list.get(i);
                if (p.val == newList.get(newListSize - 1).val && p.x == newList.get(newListSize - 1).x && !isMerged ) {
                    q.offer(new Update(newListSize - 1, p.val * 2));
                    isMerged = true;
                } else {
                    newList.add(new Pair(p.x, putPos[p.x]++, p.val));
                    newListSize++;
                    isMerged = false;
                }
            }
        }

        if(vec == 3) {
            newList.add(new Pair(init.x, putPos[init.x]--, init.val));
            for (int i = 1; i < list.size(); i++) {
                Pair p = list.get(i);
                if (p.val == newList.get(newListSize - 1).val && p.x == newList.get(newListSize - 1).x && !isMerged ) {
                    q.offer(new Update(newListSize - 1, p.val * 2));
                    isMerged = true;
                } else {
                    newList.add(new Pair(p.x, putPos[p.x]--, p.val));
                    newListSize++;
                    isMerged = false;
                }
            }
        }


        while(!q.isEmpty()){
            Update update = q.poll();

            newList.get(update.index).val = update.val;
        }
        // 블럭 움직임 구현
        return newList;
    }

    private int result = Integer.MIN_VALUE;
    void dfs(List<Pair> list, int depth){
        if(depth >= 5) {
            int max = Integer.MIN_VALUE;
            for(var k : list){
                max = Math.max(max, k.val);
            }
            result = Math.max(max, result);
            return;
            // 끝날 때 상황의 가장 큰 수 저장
        }
        for(int i = 0; i < 4; i++){
            // 0 = 상, 1 = 하, 2 = 좌, 3 = 우
            sortEachDirections(list, i);
            dfs(push(list, i), depth+1);
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Pair> list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        putPos = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val != 0)
                    list.add(new Pair(i, j, val));
            }
        }

        dfs(list, 0);

        System.out.println(result);
    }




    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}

