import java.util.LinkedList;
import java.util.Queue;
class Solution {

    boolean solution(String s) {
        boolean answer = true;
        char[] ch = s.toCharArray();
        int num = 0;
        Queue<String> q = new LinkedList<>();
        for(char c : ch){
            if(c == '('){
                num +=1;
            } else {
                num -=1;
            }
            if(num<0){
                return false;
            }
        }
        return num ==0;
    }
}