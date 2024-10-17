import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a : A){
            pq.offer(a); // 1 1 3 7
        }
        
        Arrays.sort(B); // 2 2 6 8
        for(int i = 0; i<B.length; i++){
            while(!pq.isEmpty()){
                if(B[i] > pq.peek()){
                    pq.poll();
                    answer++;
                    break;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}

//A팀은고정 B팀 순서를 변경