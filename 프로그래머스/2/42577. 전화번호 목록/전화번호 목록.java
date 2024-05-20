import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String str: phone_book){
            hm.put(str, 1);
        }
        
        for(String phone_number : phone_book){
            for(int j = 1; j<phone_number.length(); j++){
                String tmpStr = phone_number.substring(0,j);
                if(hm.containsKey(tmpStr)){
                    return false;
                }
            }
        }
        
        return true;
        
    }
}