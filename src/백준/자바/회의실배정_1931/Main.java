package 백준.자바.회의실배정_1931;

import java.io.*;
import java.util.*;

public class Main {
    // 이 부분에 static으로 사용 할 멤버 선언
    // private int max = 0; ...
    // private int[] arr; ...
    // private void dfs()...
    class point implements Comparable<point>{
        int start;
        int end;

        public point(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString(){
            return start + " " + end;
        }

        @Override
        public int compareTo(point p){
            if(end > p.end){
                return 1;
            }
            else if(end == p.end){
                if(start > p.start){
                    return 1;
                }
            }
            return -1;
        }
    }

    Vector<point> v = new Vector<>();


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            v.add(new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(v);
        int t = v.get(0).end; // 현재 예약된 종료 시간
        int count = 1;
        for(int i = 1 ; i < n; i++){
            if(t <= v.get(i).start){
                t = v.get(i).end;
                count++;
            }
        }

        System.out.println(count);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}