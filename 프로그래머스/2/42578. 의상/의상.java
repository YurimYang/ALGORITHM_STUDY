import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        //HashMap 초기화
        HashMap<String, Integer> hm = new HashMap<>();
        for(String[] tmp : clothes){
            hm.put(tmp[1], hm.getOrDefault(tmp[1], 0) + 1);
        } //의상분류 , 개수
        
        // 조합 생각하기 
        for(int value : hm.values()){
            answer *= (value + 1);
        }
        answer -= 1;
        
        
    
        
        return answer;
    }
}

