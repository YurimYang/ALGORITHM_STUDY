import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //오름차순으로 수를 꺼냄

        for(int s :scoville){
            pq.add(s);
        }


        while(pq.peek()<K && pq.size() > 1){
            answer++;
            int first = pq.poll();
            int second = pq.poll();
            int mixed = first + second * 2;
            pq.add(mixed);
        }

        //모든 음식의 스코빌 지수를 K이상으로 만들 수 없는 경우 -1 return
        if(pq.peek() < K){
            return -1;
        }
        return answer;
    }
}