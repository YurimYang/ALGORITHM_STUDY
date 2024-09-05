import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();
        HashMap<String, Integer> timeHm = new HashMap<>();
        HashMap<String, Integer> moneyHm = new HashMap<>();
        
        for(String record : records){
            String[] recordSplit = record.split(" ");
            if(recordSplit[2].equals("IN")){
                hm.put(recordSplit[1], recordSplit[0]);
            } else if (recordSplit[2].equals("OUT")){
                int time = countTime(hm.get(recordSplit[1]), recordSplit[0]);
                timeHm.put(recordSplit[1], timeHm.getOrDefault(recordSplit[1], 0) + time);
                hm.remove(recordSplit[1]);
            }
        }
        
        //입차하고 출차 안한 차들 정리
        if(hm.size() > 0) {
            for(String key : hm.keySet()){
                int time = countTime(hm.get(key), "23:59");
                timeHm.put(key, timeHm.getOrDefault(key, 0) + time);
            }
        }

        for(String key : timeHm.keySet()){
            moneyHm.put(key, calculateMoney(timeHm.get(key), fees));
            
        }
        
        List<String> keySet = new ArrayList<>(moneyHm.keySet());
        Collections.sort(keySet);
        
        for(String key : keySet){
            answer.add(moneyHm.get(key));
        }
        return answer;
    }
    
    //주차한 차들 시간 계산
    public int countTime(String timeStart, String timeEnd){
        int timeStartMin = Integer.valueOf(timeStart.split(":")[0]) * 60 + Integer.valueOf(timeStart.split(":")[1]);
        int timeEndMin = Integer.valueOf(timeEnd.split(":")[0]) * 60 + Integer.valueOf(timeEnd.split(":")[1]);
        return timeEndMin - timeStartMin;
    }
    
    //돈 계산
    public int calculateMoney(int time, int[] fees){
        if(time > fees[0]){
            int ceilResult = (int) Math.ceil((time - fees[0]) / Double.valueOf(fees[2]));
            return fees[1] + ceilResult * fees[3];
        } else {
            return fees[1];
        }
    }
}