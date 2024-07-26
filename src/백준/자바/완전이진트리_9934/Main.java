package 백준.자바.완전이진트리_9934;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void visit(int K){
        arr[K] = tree[index++];
    }
    static void inOrder(int K){
        if(K >= size) return;
        inOrder(K * 2);
        visit(K);
        inOrder(K * 2 + 1);
    }

    static int K, size, index = 0;
    static int[] arr, tree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        size = (int)Math.pow(2, K);

        arr = new int[size];
        tree = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i  =0; i < size-1; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        inOrder(1);

        StringBuilder sb = new StringBuilder();

        int i = 1;
        int lineNum =1;
        int count = 0;
        while(i < size){
            if(lineNum == count){
                sb.append('\n');
                count = 0;
                lineNum *= 2;
            }
            sb.append(arr[i]+" ");
            count++;
            i++;
        }

        System.out.println(sb);

    }
}
