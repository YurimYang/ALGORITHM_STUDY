import java.util.*;

class Solution {
    Queue<Long> queueOne = new LinkedList<>();
    Queue<Long> queueTwo = new LinkedList<>();
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i< queue1.length; i++){
            sum1 += Long.valueOf(queue1[i]);
            sum2 += Long.valueOf(queue2[i]);
            queueOne.add(Long.valueOf(queue1[i]));
            queueTwo.add(Long.valueOf(queue2[i]));
        }

        while(sum1 != sum2){

            
            if(answer > (queue1.length + queue2.length) * 2){
                return -1;
            }
            
            long peek = 0;
            if(sum1 > sum2){
                peek = queueOne.poll();
                queueTwo.add(peek);
                sum1 -= peek;
                sum2 += peek;
            } else {
                peek = queueTwo.poll();
                queueOne.add(peek);
                sum2 -= peek;
                sum1 += peek;
            }
            answer++;
        } 
        return answer;
    }
}