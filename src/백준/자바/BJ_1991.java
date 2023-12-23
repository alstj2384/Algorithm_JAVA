package 백준.자바;
import java.util.*;

public class BJ_1991 {
    static Scanner sc = new Scanner(System.in);

    static class Pair{
        public String prev;
        public String next;

        public Pair(String a, String b){
            prev= a;
            next= b;
        }
    }
    static HashMap map = new HashMap<String, Pair>();
    public static void main(String[] args) {

        int a = sc.nextInt();

        for(int i = 0 ; i< a; i++)
            map.put(sc.next(), new Pair(sc.next(), sc.next()));


        vlr("A");
        System.out.println();
        lvr("A");
        System.out.println();
        lrv("A");
    }

    static void lvr(String a){ // 중위 순회
        if(a.equals(".")) return;
        Pair p = (Pair)(map.get(a));
        lvr(p.prev);
        System.out.print(a);
        lvr(p.next);
    }
    static void vlr(String a){
        if(a.equals(".")) return;
        Pair p = (Pair)(map.get(a));
        System.out.print(a);
        vlr(p.prev);
        vlr(p.next);
    }
    static void lrv(String a){
        if(a.equals(".")) return;
        Pair p = (Pair)(map.get(a));
        lrv(p.prev);
        lrv(p.next);
        System.out.print(a);
    }
}
