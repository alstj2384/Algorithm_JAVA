package 프로그래머스.자바.양궁대회;
class Solution {
    int[] arr;
    int[] lion = new int[11];
    int[] record = new int[11];
    int gap = Integer.MIN_VALUE;
    int N;
    boolean hasWin;

    int isLionWin(){
        int enemyScore = 0;
        int lionScore = 0;
        for(int i = 0; i < 11; i++){
            if(arr[i] == 0 && lion[i] == 0) continue;
            else if(arr[i] >= lion[i]){
                enemyScore += 10-i;
            } else lionScore += (10-i);
        }
        return lionScore - enemyScore;
    }

    void dfs(int pos, int depth){
        if(pos > 10) return;
        if(depth == N){
            int t = isLionWin();
            if(t > 0){
                hasWin = true;
                if(t > gap){
                    gap = t;
                    for(int j = 0; j < 11; j++){
                        record[j] = lion[j];
                    }
                }
                else if(t == gap){
                    for(int i = 10; i >= 0; i--){
                        if(record[i] < lion[i]){
                            for(int j = 0; j < 11; j++){
                                record[j] = lion[j];
                            }
                            break;
                        } else if(record[i] > lion[i]) break;
                    }
                }
            }
            return;
        }
        if(lion[pos] > arr[pos]){
            dfs(pos+1, depth);
        }
        else{
            lion[pos] += 1;
            dfs(pos, depth+1);
            lion[pos] -= 1;

            dfs(pos+1, depth);
        }
    }
    public int[] solution(int n, int[] info) {
        int[] answer = {-1};
        arr = info;
        N = n;
        dfs(0, 0);
        answer = hasWin ? record : answer;

        return answer;
    }
}
