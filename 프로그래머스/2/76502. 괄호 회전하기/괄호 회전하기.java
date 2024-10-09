import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int count = s.length(); //회전 경우의 수
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<s.length(); i++){
            String newString = s.substring(i, s.length()) + s.substring(0,i);
            if(isCorrectString(newString)){
                answer++;
            }
        }
        
        
        return answer;
    }
               
    
    public boolean isCorrectString(String sentence){
        Stack<Character> stack = new Stack<>();
        for(char ch : sentence.toCharArray()){
            if(!stack.isEmpty()&& isCouple(stack.peek(), ch)){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    
    public boolean isCouple(Character in, Character out){
        if((in == '{' && out == '}') || (in == '(' && out == ')') 
           || (in == '[' && out ==']')){
            return true;
        } 
        return false;
    }
}
