import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numberStrs = new String[numbers.length];
        
        for(int i = 0; i< numbers.length; i++){
            numberStrs[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numberStrs, (o1,o2) -> (o2+o1).compareTo(o1+o2));
        
        for(String numberStr : numberStrs){
            answer+= numberStr;
        }
        
        if(answer.charAt(0) == '0'){
            answer = "0";
        }
        
        
        
        return answer;
    }
}