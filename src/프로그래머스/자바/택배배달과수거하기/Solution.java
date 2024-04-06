package 프로그래머스.자바.택배배달과수거하기;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;

        // 1. 투 포인터 각각 최대점부터 시작
        int d, p;
        d = p = n-1;

        // 2. 최대 거리를 저장할 변수
        int dist = 0;

        long result = 0;
        // 3. d, p가 모두 -1이 되면 멈춤
        while(d >= 0 || p >= 0){
            dist = Integer.MIN_VALUE;
            int count = cap;
            while(count > 0 && d >= 0){
                if(deliveries[d] > 0) {
                    dist = Math.max(dist, d);
                    deliveries[d] -= 1;
                    count--;
                } else d -= 1;
            }

            count = cap;
            while(count > 0 && p >= 0){
                if(pickups[p] > 0) {
                    dist = Math.max(dist, p);
                    pickups[p] -= 1;
                    count--;
                } else p -= 1;
            }

            if(dist == Integer.MIN_VALUE) break;
            result += (dist+1)*2;
        }


        answer = result;
        return answer;
    }
}
