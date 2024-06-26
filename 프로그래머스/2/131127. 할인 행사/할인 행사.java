import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, Integer> wantHm = new HashMap<>();
        int answer = 0;
        int count = 0;
        for(int i = 0; i < want.length; i++){
            wantHm.put(want[i], number[i]);
        }
        for(int i = 0; i < discount.length; i++){
            hm = new HashMap<>();
            count = 0;
            if(i + 9 < discount.length){
                for(int j = i; j<i+10; j++){
                    hm.put(discount[j], hm.getOrDefault(discount[j], 0) + 1);
                }
                for(String keys : wantHm.keySet()){
                    if(hm.get(keys) == wantHm.get(keys)){
                        count++;
                    }    
                }                 
                if(count == wantHm.size()){
                    answer++;
                } 
            }
        }
        return answer;
    }
}

