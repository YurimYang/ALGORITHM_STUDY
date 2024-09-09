import java.util.*;
import java.io.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0){
            int after = storey % 10; //나머지 
            storey /= 10; //몫
            
            if(after == 5) {
                if (storey % 10 >= 5){
                    answer += (10-after);
                    storey++;
                } else {
                    answer += after;
                }
            } else if (after > 5) {
                answer += (10-after);
                storey++;
            } else {
                answer += after;
            }
        }
        
        return answer;
    }
}

