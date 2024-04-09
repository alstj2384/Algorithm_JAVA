package 프로그래머스.자바.k진수에서소수개수구하기;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(true){
            if(n == 0) break;
            int a = n / k;
            int b = n % k;
            n = a;
            sb.append(b);
        }

        String s = sb.reverse().toString()+"0";
        sb = new StringBuilder();
        boolean isPrime = true;

        int i = 0;
        while(i < s.length()){
            // 0인 경우
            if(s.charAt(i) == '0'){
                String tmp = sb.toString();
                if(!tmp.equals("") && !tmp.equals("1")){
                    long val = Long.parseLong(tmp);
                    isPrime = true;
                    if(val != 2){
                        for(int j = 2; j < (int)Math.sqrt(val)+1; j++){
                            if(val % j == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                    }
                    if(isPrime) answer += 1;
                }
                i += 1;
                sb = new StringBuilder();
            }
            else{
                sb.append(s.charAt(i));
                i += 1;
            }
        }

        return answer;
    }
}