import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i< prices.length; i++){
            int curr = prices[i];
            Stack<Integer> stack = new Stack<>();
            for(int j = i+1; j<prices.length; j++){
                stack.push(prices[j]);
                if(curr > prices[j]){
                    break;
                }
            }
            answer[i] = stack.size();
        }
        
        
        return answer;
    }
}