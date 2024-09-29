import java.util.*;
import java.io.*;

class Solution {
    static Queue<Integer> queue = new LinkedList<>();
    static HashMap<Integer, Integer> map = new HashMap<>();
    static List<Integer> list = new ArrayList<>();
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        //남은 날짜 queue에 추가
        for(int i = 0; i< progresses.length; i++){
            int left = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] == 0){
                queue.add(left);
            } else {
                queue.add(left+1);
            }
        }
        
        
        int day = 0;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(map.isEmpty()){
                map.put(curr, 1);
                day = curr;
                list.add(day);
            } else {
                if(day >= curr){
                    map.put(day, map.get(day) + 1);
                } else if (day < curr) {
                    map.put(curr, 1);
                    day = curr;
                    list.add(day);
                }
            } 
        }
        
        for(int i : list){
            answer.add(map.get(i));
        }
        
        
        
        return answer;
    }
}