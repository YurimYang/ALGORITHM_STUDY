import java.util.*;
class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if(isLen(s) && isNumber(s)){
            return true;
        }
        return answer;
    }
    
    public boolean isLen(String s){
        if(s.length() == 4 || s.length() == 6){
            return true;
        }
        return false;
    }
    
    public boolean isNumber(String s) {
        char[] charArr = s.toCharArray();
        for(char ch : charArr){
            if(ch < '0' || ch > '9'){
                return false;
            }
        }
        return true;
    }
}