package 프로그래머스.자바.퍼즐게임챌린지;
class Solution {
    public boolean check(int val, int[] diffs, int[] times, long limit){
        // 구현
        // limit보다 시간이 짧으면 true, 아니면 false;
        long t = 0L;

        t += times[0];

        for(int i = 1; i < diffs.length ; i++){
            if(val >= diffs[i]){
                t += times[i];
            } else{
                int tryTime = diffs[i] - val;
                int costTime = times[i] + times[i-1];
                t += tryTime * costTime + times[i];
            }
            // System.out.println(t);
        }
        return limit >= t;

    }
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        // 이분탐색 수행해야함
        // 목적은 가능한 level중 가장 낮은 Level
        int low = 1;
        int high = 100_000;

        // System.out.println(check(39354, diffs, times, limit));

        while(low <= high){
            // diffs의 최댓값보다 Level이 높으면, 무조건 true(가능)
            // F F ... F T .. T T
            // check[low] = F
            // check[high] = T
            int mid = (low + high) / 2;
            boolean b = check(mid, diffs, times, limit);
            if(b){
                // 가능한 상태, 오른쪽 범위 줄이기
                high = mid - 1;
            } else{
                // 불가능한 상태, 왼쪽 범위 줄이기
                low = mid + 1;
            }
        }

        // System.out.println(low + " " + high);

        answer= low;
        return answer;
    }
}