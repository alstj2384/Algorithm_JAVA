package 프로그래머스.자바.신고결과받기;
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, ArrayList<String>> report_from = new HashMap<>();
        Map<String, Integer> report_count = new HashMap<>();

        for(int i = 0; i < id_list.length; i++){
            report_from.put(id_list[i], new ArrayList<>());
            report_count.put(id_list[i], 0);
        }


        ArrayList<String> list;
        boolean is_reported = false;
        for(int i = 0; i < report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            String from = st.nextToken();
            String to = st.nextToken();

            list = report_from.get(from);
            if(list.isEmpty()){
                list.add(to);
                report_count.put(to, report_count.get(to)+1);
            } else{
                is_reported = false;
                for(var q : list){
                    if(q.equals(to)) {
                        is_reported = true;
                        break;
                    }
                }

                if(!is_reported){
                    list.add(to);
                    report_count.put(to, report_count.get(to)+1);
                }
            }
        }

        for(int i = 0; i < id_list.length; i++){
            ArrayList<String> li = report_from.get(id_list[i]);
            for(int j = 0; j < li.size(); j++){
                if(report_count.get(li.get(j)) >= k) answer[i] += 1;
            }
        }

        return answer;
    }
}