import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        for(int h = 0; h<=citations.length; h++){
            int cnt = 0;
            int notCnt = 0;
            for(int i = 0; i< citations.length; i++){
                if(citations[i] >= h){
                    cnt++;
                } else if (citations[i] <= h){
                    notCnt++;
                }
            }
            if(cnt >= h && notCnt <= h){
                answer = h;
            }
            
        }
        return answer;
    }
}

// 논문 n 편
// h 번 이상 인용된 논문이 h 편 이상 & 나머지 논문이 h번 이하의 인용 => h의 최댓값

/**
[1,10,11] return 2
[10,11] return 2
[0,0,0,0,0] return 0
**/

