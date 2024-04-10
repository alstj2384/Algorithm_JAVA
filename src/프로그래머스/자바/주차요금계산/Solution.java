package 프로그래머스.자바.주차요금계산;
import java.util.*;
class Solution {
    static StringTokenizer st;
    int parseTimeToMin(String time){
        st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        return hour*60 + min;
    }

    int calcFee(int[] fees, int parkTime){
        if(fees[0] >= parkTime){
            return fees[1];
        }
        else{
            return fees[1] + (int)(Math.ceil((double)(parkTime-fees[0]) / (double)fees[2])) * fees[3];
        }

    }
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, Integer> inOut = new TreeMap<>();
        Map<String, Integer> parkTime = new HashMap<>();


        for(int i = 0; i < records.length; i++){
            st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String carNum = st.nextToken();
            String enter = st.nextToken();

            parkTime.putIfAbsent(carNum, 0);

            // 입차인 경우
            if(enter.equals("IN")){
                inOut.put(carNum, parseTimeToMin(time));
            }
            // 출차인 경우
            else {
                int parkT = parseTimeToMin(time)-inOut.get(carNum);
                inOut.put(carNum, Integer.MAX_VALUE);

                parkTime.put(carNum, parkTime.get(carNum) + parkT);
            }
        }

        for(var k : inOut.keySet()){
            if(inOut.get(k) != Integer.MAX_VALUE){
                parkTime.put(k, parkTime.get(k) + (parseTimeToMin("23:59") - inOut.get(k)));
            }
        }

        answer = new int[inOut.keySet().size()];
        int i = 0;
        for(var k : inOut.keySet()){
            answer[i++] = calcFee(fees, parkTime.get(k));
        }
        return answer;
    }
}
