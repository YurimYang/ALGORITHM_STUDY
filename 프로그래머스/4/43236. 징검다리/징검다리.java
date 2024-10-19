import java.util.*;
import java.io.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks); //오름차순 정렬
        //2 11 14 17 21
        
        int left = 1; //지점간 최소 거리
        int right = distance; //저점간 최대 거리
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(getRemovedRockCnt(rocks, mid, distance) > n){
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
 
        }

        return answer;
    }
    
    public int getRemovedRockCnt(int[] rocks, int mid, int distance){
        int start = 0;
        int cnt = 0;
        for(int i = 0; i<rocks.length; i++){
            if(rocks[i] - start < mid){
                cnt++;
            } else {
                start = rocks[i];
            }
        }
        
        //도착지까지의 거리
        if(distance - start < mid){
            cnt++;
        }

        return cnt;
    }
}

// 0 2 11 14 17 21 25

// 11 3 3 8 3
// 11 3 7 4 
