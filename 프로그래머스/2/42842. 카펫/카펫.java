import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        List<Pair> list = new ArrayList<>();
        
        //1. yellow의 가로 세로 구하기
        for(int i = 1; i <= yellow; i++){
            if(yellow % i == 0){
                int otherNum = yellow/i;
                Pair pair1 = new Pair(otherNum, i);
                Pair pair2 = new Pair(i, otherNum);
                
                if(otherNum >= i && !list.contains(pair1) && !list.contains(pair2)){
                    list.add(new Pair(otherNum, i));
                } 
            }
        }
        
        for(Pair pair : list){
            if((pair.x + 2) * (pair.y + 2) == brown+yellow){
                answer[0] = pair.x + 2;
                answer[1] = pair.y + 2;
            }
        }
        
        
        return answer;
    }
}

class Pair{
    int x;
    int y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}