import java.util.*;
import java.io.*;

class Solution {
    HashMap<String, String> hm = new HashMap<>();

    public List<String> solution(String[] records) {
        List<String> answer = new ArrayList<>();
        for(String record : records){
            String[] splitArr = record.split(" ");
            String msg = splitArr[0];
            if(msg.equals("Enter") || msg.equals("Change")){
                hm.put(splitArr[1], splitArr[2]);
            } 
        }
        for(String record : records){
            String[] splitArr = record.split(" ");
            String msg = splitArr[0];
            if(msg.equals("Enter")){
                answer.add(hm.get(splitArr[1]) + "님이 들어왔습니다.");
            } else if(msg.equals("Leave")) {
                answer.add(hm.get(splitArr[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer;
    }
}