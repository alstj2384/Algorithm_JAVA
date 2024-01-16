package 백준.자바.구슬탈출2_13460;

import java.io.*;
import java.util.*;

public class Main {
    private Pair Red, Blue;
    private int N, M;
    private char[][] map;


    PairSet slideLeft(PairSet ps){
        Pair red;
        Pair blue;
        boolean redGoal = false;
        boolean blueGoal = false;
        // 두 공 중,y값이 더 작은 공을 먼저 움직인다.
        // 반환하는 값은 두 공의 변경된 위치 정보임.
        if(ps.Red.Y < ps.Blue.Y){
            int x = ps.Red.X, y = ps.Red.Y;
            while(map[x][y-1] != '#'){
                if(map[x][y-1] == 'O'){
                    redGoal = true;
                    break;
                }
                y--;
            }
            if(redGoal) red = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
            else red = new Pair(x, y);

            x = ps.Blue.X;  y = ps.Blue.Y;
            while(map[x][y-1] != '#'){
                if(red.Y == y-1 && red.X == x) break;
                if(map[x][y-1] == 'O'){
                    return null;
                }
                y--;
            }
            blue = new Pair(x, y);
            return ps.equals(new PairSet(red, blue, ps.count)) ? null : new PairSet(red, blue, ps.count+1);
        }
        else{
            int x = ps.Blue.X, y = ps.Blue.Y;
            while(map[x][y-1] != '#'){
                if(map[x][y-1] == 'O'){
                    return null;
                }
                y--;
            }
            blue = new Pair(x, y);

            x = ps.Red.X;  y = ps.Red.Y;

            while(map[x][y-1] != '#'){
                if(blue.Y == y-1 && blue.X ==x) break;
                if(map[x][y-1] == 'O'){
                    redGoal = true;
                    break;
                }
                y--;
            }
            if(redGoal) red = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
            else red = new Pair(x, y);

            return ps.equals(new PairSet(red, blue, ps.count)) ? null : new PairSet(red, blue, ps.count+1);
        }
    }

    PairSet slideRight(PairSet ps){
        // 두 공중 y값이 더 큰 공을 먼저 움직인다.
        Pair red;
        Pair blue;
        boolean redGoal = false;
        boolean blueGoal = false;
        if(ps.Red.Y > ps.Blue.Y){
            int x = ps.Red.X, y = ps.Red.Y;
            while(map[x][y+1] != '#'){
                if(map[x][y+1] == 'O'){
                    redGoal = true;
                    break;
                }
                y++;
            }
            if(redGoal) red = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
            else red = new Pair(x, y);

            x = ps.Blue.X;  y = ps.Blue.Y;
            while(map[x][y+1] != '#'){
                if(red.Y == y+1 && red.X == x) break;
                if(map[x][y+1] == 'O'){
                    return null;
                }
                y++;
            }
            blue = new Pair(x, y);
            return ps.equals(new PairSet(red, blue, ps.count)) ? null : new PairSet(red, blue, ps.count+1);
        }
        else{
            int x = ps.Blue.X, y = ps.Blue.Y;
            while(map[x][y+1] != '#'){
                if(map[x][y+1] == 'O'){
                    return null;
                }
                y++;
            }
            blue = new Pair(x, y);

            x = ps.Red.X;  y = ps.Red.Y;

            while(map[x][y+1] != '#'){
                if(blue.Y == y+1 && blue.X == x) break;
                if(map[x][y+1] == 'O'){
                    redGoal = true;
                    break;
                }
                y++;
            }
            if(redGoal) red = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
            else red = new Pair(x, y);

            return ps.equals(new PairSet(red, blue, ps.count)) ? null : new PairSet(red, blue, ps.count+1);
        }
    }

    PairSet slideUp(PairSet ps){
        // 두 공 중, x값이 더 작은 공을 먼저 움직인다.
        Pair red;
        Pair blue;
        boolean redGoal = false;
        boolean blueGoal = false;
        if(ps.Red.X < ps.Blue.X){
            int x = ps.Red.X, y = ps.Red.Y;
            while(map[x-1][y] != '#'){
                if(map[x-1][y] == 'O'){
                    redGoal = true;
                    break;
                }
                x--;
            }
            if(redGoal) red = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
            else red = new Pair(x, y);

            x = ps.Blue.X;  y = ps.Blue.Y;
            while(map[x-1][y] != '#'){
                if(red.X == x-1 && red.Y == y) break;
                if(map[x-1][y] == 'O'){
                    return null;
                }
                x--;
            }
            blue = new Pair(x, y);
            return ps.equals(new PairSet(red, blue, ps.count)) ? null : new PairSet(red, blue, ps.count+1);
        }
        else{
            int x = ps.Blue.X, y = ps.Blue.Y;
            while(map[x-1][y] != '#'){
                if(map[x-1][y] == 'O'){
                    return null;
                }
                x--;
            }
            blue = new Pair(x, y);

            x = ps.Red.X;  y = ps.Red.Y;

            while(map[x-1][y] != '#'){
                if(blue.X == x-1 && blue.Y == y) break;
                if(map[x-1][y] == 'O'){
                    redGoal = true;
                    break;
                }
                x--;
            }
            if(redGoal) red = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
            else red = new Pair(x, y);

            return ps.equals(new PairSet(red, blue, ps.count)) ? null : new PairSet(red, blue, ps.count+1);
        }

    }

    PairSet slideDown(PairSet ps){
        // 두 공중 x 값이 더 큰 공을 먼저 움직인다.
        Pair red;
        Pair blue;
        boolean redGoal = false;
        boolean blueGoal = false;
        if(ps.Red.X > ps.Blue.X){
            int x = ps.Red.X, y = ps.Red.Y;
            while(map[x+1][y] != '#'){
                if(map[x+1][y] == 'O'){
                    redGoal = true;
                    break;
                }
                x++;
            }
            if(redGoal) red = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
            else red = new Pair(x, y);

            x = ps.Blue.X;  y = ps.Blue.Y;
            while(map[x+1][y] != '#'){
                if(red.X == x+1 && red.Y == y) break;
                if(map[x+1][y] == 'O'){
                    return null;
                }
                x++;
            }
            blue = new Pair(x, y);
            return ps.equals(new PairSet(red, blue, ps.count)) ? null : new PairSet(red, blue, ps.count+1);
        }
        else{
            int x = ps.Blue.X, y = ps.Blue.Y;
            while(map[x+1][y] != '#'){
                if(map[x+1][y] == 'O'){
                    return null;
                }
                x++;
            }
            blue = new Pair(x, y);

            x = ps.Red.X;  y = ps.Red.Y;

            while(map[x+1][y] != '#'){
                if(blue.X == x+1 && blue.Y == y) break;
                if(map[x+1][y] == 'O'){
                    redGoal = true;
                    break;
                }
                x++;
            }
            if(redGoal) red = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
            else red = new Pair(x, y);

            return ps.equals(new PairSet(red, blue, ps.count)) ? null : new PairSet(red, blue, ps.count+1);
        }
    }

    boolean checkGoal(PairSet ps){
        return ps.Red.X == Integer.MAX_VALUE && ps.Red.Y == Integer.MAX_VALUE;
    }

    int bfs(){
        // 기울이는 횟수는 최대 10번
        // 현재 red, blue 의 상태에서 4방향으로 기울여서
        // for 1 to 4, 4 방향에 대해서 add.
        Queue<PairSet> q = new LinkedList<>();

        q.add(new PairSet(Red, Blue, 0));

        while(!q.isEmpty()){
            PairSet ps;
            if((ps = q.poll()) == null) continue;
            if(ps.count > 10) continue;
            if(checkGoal(ps)) return ps.count;

//            System.out.println("Red ("+ ps.Red.X+","+ps.Red.Y+"), Blue ("+ps.Blue.X+","+ps.Blue.Y+")");

            q.add(slideLeft(ps));
            q.add(slideRight(ps));
            q.add(slideUp(ps));
            q.add(slideDown(ps));

        }
        return -1;
    }


    class Pair{
        int X;
        int Y;
        public Pair(int x, int y){
            X = x;
            Y = y;
        }
    }
    class PairSet{
        Pair Red;
        Pair Blue;
        int count;
        public PairSet(Pair red, Pair blue, int count){
            Red = red;
            Blue = blue;
            this.count = count;
        }

        @Override
        public boolean equals(Object o){
            PairSet ps = (PairSet)o;

            return Red.X == ps.Red.X && Red.Y == ps.Red.Y && Blue.X == ps.Blue.X && Blue.Y == ps.Blue.Y;
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++){
            String s=  br.readLine();
            for(int j = 0; j < M; j++){
                if(s.charAt(j) == 'B'){
                    Blue = new Pair(i,j);
                    map[i][j] = '.';
                }
                else if(s.charAt(j) == 'R'){
                    Red = new Pair(i, j);
                    map[i][j] = '.';
                }
                else map[i][j] = s.charAt(j);
            }
        }


        System.out.println(bfs());
//        PairSet ps = slideUp(new PairSet(Red,Blue, 1));
//        System.out.println("Red ("+ ps.Red.X+","+ps.Red.Y+"), Blue ("+ps.Blue.X+","+ps.Blue.Y+")");
//        ps = slideLeft(ps);
//        System.out.println("Red ("+ ps.Red.X+","+ps.Red.Y+"), Blue ("+ps.Blue.X+","+ps.Blue.Y+")");
//        ps = slideRight(ps);
//        System.out.println("Red ("+ ps.Red.X+","+ps.Red.Y+"), Blue ("+ps.Blue.X+","+ps.Blue.Y+")");
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
