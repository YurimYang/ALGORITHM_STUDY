import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); //내림차순 (default : 오름차순)
        
        for(int p : priorities){
            queue.offer(p);
        }
        
        while(!queue.isEmpty()){
            for(int i = 0; i< priorities.length; i++){
                if(queue.peek() == priorities[i]) {
                    queue.poll();
                    answer++;
                    
                    if(location == i){
                        return answer;
                    }
                }
                
            }
        }
        
        
        return answer;
    }
}