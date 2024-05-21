import java.util.*;
import java.io.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    public String solution(int[] numbers) {
        String answer = "";
        String[] strings = new String[numbers.length];
        
        for(int i = 0; i<numbers.length; i++){
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        for(String str : strings){
            sb.append(str);
        }
        
        answer = sb.toString();
        
        if(answer.charAt(0) == '0'){
            answer = "0";
        }
        
        


        return answer;
    }
}



