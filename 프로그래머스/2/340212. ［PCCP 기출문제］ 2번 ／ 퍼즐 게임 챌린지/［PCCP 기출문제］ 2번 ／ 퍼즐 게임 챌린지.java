import java.util.*;
import java.io.*;

//최소의 숙련도 구하기
//이분탐색 문제
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        return binarySearch(diffs,times,limit);
    }
    
    public int binarySearch(int[] diffs, int[] times, long limit){
        int min = 100000;
        int max = 1;

        while(max <= min){
            long count = 0;
            int mid = (min + max) / 2;
            
            for(int i = 0; i<diffs.length; i++){
                if(mid >= diffs[i]){
                    count += (long) times[i];
                } else {
                    count += (long) (times[i-1] + times[i]) * (long)(diffs[i] - mid) + (long) times[i];
                }
            }
            if (count > limit) {
                max = mid + 1;   
            } else {
               min = mid - 1;
            } 
        }
        return max;
    }
}
//diff : 난이도
//time_cur : 퍼즐의 소요시간
//time_prev : 이전 퍼즐의 소요시간
//level : 내 숙련도 
//diff-level만큼 틀림 time_cur + time_prev * diff_level + time_cur 

