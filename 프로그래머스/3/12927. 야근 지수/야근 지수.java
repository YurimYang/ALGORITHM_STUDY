import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i<works.length; i++){
            pq.offer(works[i]);
        }
        
        while(n > 0){
            int max = pq.poll();
            if(max <=0){
                break;
            }
            pq.offer(max - 1);
            n--;
        }
        
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}
//야근피로도 = 야근 시작 시점 에서 남은 일의 작업량을 제곱하여 더한 값
//n시간동안 야근 피로도를 최소화하도록 일할 것

