package 백준.자바.카드2_2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            q.offer(i);
        }
        int i = N-1;
        while(i > 0){
            q.poll();
            q.offer(q.poll());
            i--;
        }

        System.out.println(q.poll());
    }
}
