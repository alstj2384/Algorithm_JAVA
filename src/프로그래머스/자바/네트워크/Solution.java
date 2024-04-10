package 프로그래머스.자바.네트워크;
class Solution {
    boolean[] visited;
    boolean dfs(int x, int n, int[][] computers){
        if(visited[x]) return false;
        visited[x] = true;

        for(int i = 0; i < n; i++){
            if(i != x && computers[x][i] == 1){
                dfs(i, n, computers);
            }
        }
        return true;
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(dfs(i, n, computers)){
                answer+=1;
            }
        }
        return answer;
    }
}
