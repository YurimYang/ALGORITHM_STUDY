import java.util.*;
import java.io.*;

class Solution {
    public String solution(String number, int k) {        
        StringBuilder answer = new StringBuilder();
        int start = 0;
        int len = number.length() - k; //이 길이 만큼씩 구할 것
        while(start < number.length() && answer.length() != len) {
            int max = 0;
            for(int i = start; i<k + answer.length() + 1; i++){
                if(max < number.charAt(i) - '0'){
                    max = number.charAt(i) - '0';
                    start = i + 1;
                }
            }
            answer.append(Integer.toString(max));
        }
        return answer.toString();
    }
}
