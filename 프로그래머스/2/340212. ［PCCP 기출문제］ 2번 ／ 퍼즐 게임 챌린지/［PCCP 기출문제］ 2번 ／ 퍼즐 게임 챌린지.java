import java.util.*;
import java.io.*;

class Solution {
    //현재 level 값으로 가능한지 판단하는 함수
    static boolean isImpossible(int[] diffs, int[] times, long level, long limit){
        long t = (long)times[0];
        
        for(int i =1; i<times.length; i++){
            if(diffs[i] > level){
                t += ((long)diffs[i] - level) * ((long)times[i-1] + (long)times[i]);
            }
            t += (long)times[i];
        }
        
        return limit < t;
    }
    /*
    이진탐색을 활용, mid값을 level로 설정
    */
    public int solution(int[] diffs, int[] times, long limit) {

        long left = 1;
        long right = limit;
        
        while(left < right){
            long mid = (left + right) / 2;
            
            if(isImpossible(diffs, times, mid, limit)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return (int)left;
    }
}