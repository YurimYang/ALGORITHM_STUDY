import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(String s) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        String[] split = s.substring(1,s.length()-1).split("},");
        Arrays.sort(split, (o1, o2) -> o1.length() - o2.length());
        toCharArray("{2,1,3,4}");
        for(String str : split){
            for(String ch : toCharArray(str)){
                
                    int key = Integer.parseInt(String.valueOf(ch));
                    if(hm.containsKey(key)){
                        continue;
                    } else {
                        hm.put(key, hm.getOrDefault(key,0) + 1);
                        answer.add(key);
                    }
                    
                
            }
        }
        // {2 {2,1 {2,1,3 {2,1,3,4}
             
        return answer;
    }
    
    public String[] toCharArray(String str){
        str = str.substring(1,str.length());
        if(str.charAt(str.length()-1) == '}'){
            str = str.substring(0,str.length()-1);
        }
        return str.split(",");
        
    }
}
