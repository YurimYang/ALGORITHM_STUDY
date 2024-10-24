import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;

        Queue<Integer> trucks_ing = new LinkedList<>();


        for(int t_now : truck_weights){
            while(true){
                if(trucks_ing.isEmpty()){
                    trucks_ing.offer(t_now);
                    sum += t_now;
                    answer++;
                    break;
                } else if(trucks_ing.size() == bridge_length){
                    sum -= trucks_ing.poll();
                } else {
                    if(sum + t_now <= weight){
                        trucks_ing.offer(t_now);
                        answer++;
                        sum+= t_now;
                        break;
                    } else {
                        trucks_ing.offer(0);
                        answer++;
                    }
                }
            }
        }

        return answer + bridge_length;
    }
        
        
        
        
}
