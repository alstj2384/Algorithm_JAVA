package 프로그래머스.자바.행렬테두리회전하기;
class Solution {
    int[][] map;

    int rotate(int x1, int y1, int x2, int y2){
        int prev = 100_000_000;
        int next = 0;
        int min = 100_000_000;
        for(int i = y1; i <= y2-1; i++){
            next = map[x1][i];
            min = Math.min(min, next);
            map[x1][i] = prev;
            prev = next;
        }
        for(int i = x1; i <= x2-1; i++){
            next = map[i][y2];
            min = Math.min(min, next);
            map[i][y2] = prev;
            prev = next;
        }
        for(int i = y2; i >= y1+1; i--){
            next = map[x2][i];
            min = Math.min(min, next);
            map[x2][i] = prev;
            prev = next;
        }
        for(int i = x2; i >= x1; i--){
            next = map[i][y1];
            min = Math.min(min, next);
            map[i][y1] = prev;
            prev = next;
        }
        return min;
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        map = new int[rows][columns];
        for(int i = 0; i < rows ;i++){
            for(int j = 0; j < columns; j++){
                map[i][j] = (i * columns +j+1);
            }
        }

        answer = new int[queries.length];
        int i = 0;
        for(var k : queries){
            answer[i++] = rotate(k[0]-1, k[1]-1, k[2]-1, k[3]-1);

        }
        return answer;
    }
}