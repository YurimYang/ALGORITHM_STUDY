import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] orders) {
        int answer = 0;
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 1; i<=orders.length; i++){
            stack.push(i);
            while(!stack.isEmpty()){
                if(stack.peek() == orders[idx]){
                    stack.pop();
                    answer++;
                    idx++;
                } else {
                    break;
                }
            }
        }
        

        return answer;
    }
    

}