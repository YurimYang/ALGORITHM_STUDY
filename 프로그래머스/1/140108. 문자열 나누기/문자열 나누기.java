import java.util.*;
import java.io.*;

class Solution {
    static int idx;
    public int solution(String s) {
        int answer = 1;
        int len = s.length();
        char target = s.charAt(0);
        int sameCnt = 1;
        int notSameCnt = 0;
        
        for(int i = 1; i<len-1; i++){
            if(s.charAt(i) == target){
                sameCnt++;
            } else{
                notSameCnt++;
            }
            if(sameCnt == notSameCnt){
                target = s.charAt(i+1);
                answer++;
            }
        }
        

        
        return answer;
    }

}