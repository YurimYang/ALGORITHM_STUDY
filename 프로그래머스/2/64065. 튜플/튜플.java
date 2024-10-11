import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(String s) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        String[] split = s.substring(1,s.length()-1).split("},");
        Arrays.sort(split, (o1, o2) -> o1.length() - o2.length());
        for(String str : split){
            for(String ch : toStringArray(str)){
                int key = Integer.parseInt(String.valueOf(ch));
                if(hm.containsKey(key)){
                    continue;
                } else {
                    hm.put(key, hm.getOrDefault(key,0) + 1);
                    answer.add(key);
                }
            }
        }
             
        return answer;
    }
    
    public String[] toStringArray(String str){
        str = str.substring(1,str.length());
        if(str.charAt(str.length()-1) == '}'){
            str = str.substring(0,str.length()-1);
        }
        return str.split(",");
    }
}
