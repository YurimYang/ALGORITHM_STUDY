import java.util.*;
import java.io.*;

class Solution {
    static Stack<Character> stack = new Stack<>();
    boolean solution(String s) {
        boolean answer = true;
        
        for(Character ch : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(ch);
            } else {
                if(stack.peek() == '(' && ch == ')'){
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        
        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}