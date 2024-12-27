package 프로그래머스.자바.동영상_재생기;
class Solution {
    public int StringToInt(String time){
        // String으로 표시된 시간을 초단위로 변환
        int m = Integer.parseInt(time.substring(0, 2));
        int s = Integer.parseInt(time.substring(3, 5));

        return m * 60 + s;
    }
    public String IntToString(int time){
        // 초단위 시간을 String으로 변환
        int m = time / 60;
        int s = time % 60;


        return ((m < 10) ? "0"+m :m) + ":" + ((s < 10) ? "0"+s : s);
    }
    public int next(int time, int video_len){
        // 10초 뒤로 이동한 결과 문자열을 출력
        // 동영상 끝인 경우 끝으로 세팅
        time += 10;

        return time > video_len ? video_len : time;
    }
    public int prev(int time){
        time -= 10;
        // 10초 앞으로 이동
        // 동영상 시작인 경우 00:00으로 세팅
        return time < 0 ? 0 : time;
    }
    public boolean isOpening(int time, int start, int end){
        // op_start <= time <= op_end인 경우

        return start <= time && time < end;
    }
    // public int setOpeningEnd(){
    //     return ;
    //     // 시간 관계 없이 isOpening이면 opening end로 시간 반환
    // }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        // 1. 시간 초 단위 처리, 범위 밖으로는 이동 x
        // 커맨드 입력 받기

        int video_len_t = StringToInt(video_len);
        int pos_t = StringToInt(pos);
        int op_start_t = StringToInt(op_start);
        int op_end_t = StringToInt(op_end);

        for(String command : commands){
            if(isOpening(pos_t, op_start_t, op_end_t)){
                pos_t = op_end_t;
            }

            if(command.equals("next")){
                pos_t = next(pos_t, video_len_t);
            } else {
                pos_t = prev(pos_t);
            }
        }

        if(isOpening(pos_t, op_start_t, op_end_t)){
            pos_t = op_end_t;
        }

        answer = IntToString(pos_t);
        return answer;
    }
}