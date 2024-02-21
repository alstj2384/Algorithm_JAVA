package 프로그래머스.자바.붕대감기;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        int castTime = bandage[0];
        int healPerSec = bandage[1];
        int lastHeal = bandage[2];
        int maxHealth = health;

        int attackLimit = attacks.length;

        int time = 0; // 시간
        int curAttackIndex = 0; // attacks[curAttackIndex] = 다음 공격의 시간

        int success = 0; // 연속 공격 횟수

        while(true){
            time++;

            // 몬스터가 공격하는 경우
            if(attacks[curAttackIndex][0] == time){
                health -= attacks[curAttackIndex][1];
                curAttackIndex += 1;
                success = 0;
            }
            // 몬스터가 공격하지 않는 경우
            else{
                success += 1;
                health += healPerSec;

                if(success == castTime){
                    health += lastHeal;
                    success = 0;
                }

                // 초과된 체력을 최대 체력으로 조정
                if(maxHealth < health){
                    health = maxHealth;
                }
            }

            // 체력이 0 이하가 된 경우
            if(health <= 0){
                answer = -1;
                break;
            }
            // 몬스터 공격이 끝난 경우
            if(attackLimit == curAttackIndex){
                answer = health;
                break;
            }
        }
        return answer;
    }
}