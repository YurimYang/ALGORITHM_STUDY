import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int longTime = bandage[0]; //시전시간
        int x = bandage[1]; //초당 회복량
        int y = bandage[2]; //추가 회복량
        int maxHealth = health;
        
        //최대 시간 구하기
        int fullTime = 0;
        for(int i = 0; i<attacks.length; i++){
            fullTime = Math.max(fullTime, attacks[i][0]);
        }
        
        //attacks HashMap으로 바꿔서 이중for문 안돌게 구현
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<attacks.length; i++){
            hm.put(attacks[i][0], attacks[i][1]);
        }
        
        int countTime = 0;
        boolean isHurt = false;
        for(int i = 1; i<= fullTime; i++){
            if(hm.containsKey(i)){
                health -= hm.get(i);
                countTime = 0;
            } else {
                countTime++;
                health += x;
                if(countTime == longTime){
                    health += y;
                    countTime = 0;
                }
                if(health > maxHealth){
                    health = maxHealth;
                }
            } 
            if(health <= 0){
                return -1;
            }
        }
        if(health > 0){
            return health;
        } 
        
        return -1;
    }
}

//t초 붕대
//x초만큼 회복
//t초 연속 붕대 성공시, y만큼 추가 회복
//죽으면 -1, 아니면 남은 체력 return
//attacks = 공격시간, 피해량

//bandage = 시전 시간, 초당 회복량(x), 추가회복량(y) 