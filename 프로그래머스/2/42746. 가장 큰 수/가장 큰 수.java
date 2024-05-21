import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strings = new String[numbers.length];
        
        for(int i = 0; i<numbers.length; i++){
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        
         
        for(String str : strings){
            answer += str;
        }
        
        if(answer.substring(0,1).equals("0")){
            answer = "0";
        }


        return answer;
    }
}



