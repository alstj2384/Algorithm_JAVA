package 프로그래머스.자바.귤고르기;
import java.util.*;
class Solution {
    class Pair{
        int index;
        int value;
        public Pair(int idx, int val){
            index= idx;
            value = val;
        }
    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < tangerine.length; i++)
            if(map.putIfAbsent(tangerine[i], 1) != null)
                map.put(tangerine[i], map.get(tangerine[i]) + 1);

        List<Pair> list = new ArrayList<>();
        for(var q : map.keySet()) list.add(new Pair(q, map.get(q)));

        Collections.sort(list, (o1, o2) -> o1.value - o2.value);


        int exclude = tangerine.length - k;
        int i = 0;

        while(exclude > 0){
            int v = list.get(i).value;
            if(exclude < v) break;
            else{
                exclude -= v;
                i++;
            }
        }
        answer= list.size()-i;
        return answer;
    }
}