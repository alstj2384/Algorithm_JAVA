package 프로그래머스.자바.다단계칫솔판매;import java.util.*;
class Solution {
    // 이름과 번호가 키 쌍으로 들어감.
    Map<String, Integer> map = new HashMap<>();
    int[] arr;

    void dfs(int x, int money, int[] answer){
        int giveMoney = (int)(money*0.1);
        int myMoney = money - giveMoney;

        answer[x] += myMoney;

        if(arr[x] == -1) return;
        dfs(arr[x], giveMoney, answer);
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        arr = new int[enroll.length];

        Arrays.fill(arr, -1);
        // 1. 이름을 통해 enroll배열에서 해당 이름 인덱스를 바로 얻을 수 있도록 Map에 저장
        // 2. reffreal을 사용하여 그래프 간선 추가
        // 3. arr 초기화
        for(int i = 0; i < enroll.length; i++){
            String s = referral[i];
            map.put(enroll[i], i);
            if(!s.equals("-")) arr[i] = map.get(s);
        } // -> <john, 0> <mary, 1> ...

        // 4. 각 판매마다 이익 갱신
        for(int i = 0; i < seller.length; i++){
            dfs(map.get(seller[i]), amount[i]*100, answer);
        }

        return answer;
    }
}