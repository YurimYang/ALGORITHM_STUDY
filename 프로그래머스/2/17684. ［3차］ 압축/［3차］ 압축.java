import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, Integer> hm = new HashMap<>();
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        init();
        int idx = 0;
        
        while(idx < msg.length()){
            String w = String.valueOf(msg.charAt(idx));
            int step = 0;
            boolean found = false;
            for(int j = idx+1; j<msg.length(); j++){
                String c = String.valueOf(msg.charAt(j));
                String wc = w + c;
                step += 1;
                if(hm.containsKey(wc)){
                    w = wc;
                } else {
                    answer.add(hm.get(w));
                    hm.put(wc,hm.size()+1);
                    found = true;
                    break;
                }
            }
            
            if(!found){
                answer.add(hm.get(w));
                idx += step +1;
            } else {
                idx += step;
            }
            
            
            
        }
        
        
        return answer;
    }
    
    public void init(){
        for(int i = 0; i<26; i++){
            hm.put(String.valueOf((char) ('A'+i)), i+1);
        }
    }
}

