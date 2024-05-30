import java.util.*;
class Solution {
    public static int solution(String s) {
        int answer = 0;
        String extendS = s+s;
        for(int i = 0; i<s.length();i++){
            String targetS = extendS.substring(i,i+(s.length()));
            if(isCorrectString(targetS)){
                answer++;
            }
        }
        return answer;
    }
    public static boolean isCorrectString(String s) {
        Stack<Character> stk = new Stack<>();
        Stack<Character> leftOvers = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c== '['){
                stk.push(c);
            } else if (stk.size() > 0 && c == ')' && stk.peek() == '(' ){
                leftOvers.push(stk.peek());
                stk.pop();
            } else if(stk.size() > 0 && c == '}' && stk.peek() == '{' ){
                leftOvers.push(stk.peek());
                stk.pop();
            } else if(stk.size() > 0 && c == ']' && stk.peek() == '[' ){
                leftOvers.push(stk.peek());
                stk.pop();
            }
        }        

        if(stk.isEmpty() && leftOvers.size() > 0){
            return true;
        }
        return false;
    }
}

// {(})
// (}){
// }){(
// ){(}
     