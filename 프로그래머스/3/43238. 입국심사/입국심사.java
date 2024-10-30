import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long s = 0;
        long e = (long) times[times.length - 1] * (long) n;
        
        while(s <= e){
            long m = (s + e) / 2;
            
            long peopleCnt = 0;
            for(int time : times){
                peopleCnt += m/time;
            }
            
            if(peopleCnt < n){
                s = m +1;
            } else {
                e = m-1;
                answer = m;
            }
        }
        
        
        return answer;
    }
}
