package 백준.자바.트리의부모찾기_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tree = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N+1; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            tree.get(start).add(end);
            tree.get(end).add(start);
        }

        treeParents = new int[N+1];

        findParent(1, 0);

        for(int i = 2; i < N+1; i++){
            System.out.println(treeParents[i]);
        }
    }
    static List<List<Integer>> tree;
    static int[] treeParents;
    static int N;
    static void findParent(int curNode, int prevNode){
        List<Integer> nodes = tree.get(curNode);
        treeParents[curNode] = prevNode;

        for(var node : nodes){
            if(prevNode != node) {
                findParent(node, curNode);
            }
        }
    }
}
