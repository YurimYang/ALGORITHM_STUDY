import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        for(String city : cities){
            if(isCityInCache(queue, city, cacheSize)){
                answer+=1;
                queue = LRU(queue, city);
            } else if(!isCityInCache(queue, city, cacheSize) && queue.size() <cacheSize){
                queue.add(city);
                answer+=5;
            } else {
                queue.poll();
                answer+=5;
                queue.add(city);
            }
        }
        return answer;
    }
    
    public boolean isCityInCache(Queue<String> queue, String city, int cacheSize){
        String[] tmpArr = queue.toArray(new String[0]);
        for(int i = 0; i< queue.size(); i++){
            if(tmpArr[i].toLowerCase().equals(city.toLowerCase())){
                return true;
            }
            
        }
        return false;
    }
    
    public Queue<String> LRU(Queue<String> queue, String city){
        Queue<String> tmpQueue = new LinkedList<>();
        String[] tmpArr = queue.toArray(new String[0]);
        for(int i = 0; i<queue.size(); i++){
            if(!tmpArr[i].toLowerCase().equals(city.toLowerCase())){
                tmpQueue.add(tmpArr[i]);
            }
        }
        tmpQueue.add(city);
        return tmpQueue;
    }
}

