import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long left = 0;
        long right = times[times.length-1] * (long) n; // 60초 (최대 n명 * 가장 오래걸리는 시간)
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            long peopleCnt = 0;
            for(int time : times){
                peopleCnt += mid/time;
            }
            
            if(peopleCnt < n){
                left = mid+1;
            } else {
                answer = mid;
                right = mid-1;
            }
        }

        return answer;
    }
}