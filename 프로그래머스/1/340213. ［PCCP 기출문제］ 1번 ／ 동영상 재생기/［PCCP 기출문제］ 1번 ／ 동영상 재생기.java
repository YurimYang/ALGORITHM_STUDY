import java.util.*;
import java.io.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int time = toMMSSInteger(pos);
        for(String command : commands){
            if(time >= toMMSSInteger(op_start) && time <= toMMSSInteger(op_end)){
                time = toMMSSInteger(op_end);
            }
            if(command.equals("next")){
                 time += 10;
                if(time > toMMSSInteger(video_len)){
                    time = toMMSSInteger(video_len);
                }
            } else if(command.equals("prev")){
                time -= 10;
                if(time < 0){
                    time = 0;
                }
            }
            if(time >= toMMSSInteger(op_start) && time <= toMMSSInteger(op_end)){
                time = toMMSSInteger(op_end);
            }
            System.out.println(time);
        }
        
        if(time >= toMMSSInteger(op_start) && time <= toMMSSInteger(op_end)){
            answer = op_end;
        } else {
            answer = toMMSSString(time);
        }
        
        return answer;
    }
    
    public int toMMSSInteger(String pos){
        String[] mmss = pos.split(":");
        int sec = Integer.parseInt(mmss[1]);
        int min = Integer.parseInt(mmss[0]);
        
        return min * 60 + sec;
        
    }
    
    public String toMMSSString(int mmss){
        String hour = String.valueOf(mmss/60);
        if(hour.length() == 1){
            hour = "0"+hour;
        }
        String minute = String.valueOf(mmss % 60);
        if(minute.length() == 1){
            minute = "0"+minute;
        }
        return hour + ":" + minute;
    }
}

//10초 전 이동, 10초 후 이동, 오프닝 건너뛰기 3가지 기능
//prev 
//next
//자동으로 op_start <= 재생 위치 <= op_end인경우 op_end로 이동