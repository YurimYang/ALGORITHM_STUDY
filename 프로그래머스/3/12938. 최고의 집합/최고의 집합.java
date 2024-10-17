import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(n > s){
            return new int[]{-1};
        }
        
        int devide = s/n;
        for(int i = 0; i<n; i++){
            answer[i] = devide;
        }
        
        int left = (int) s%n;
        if(left != 0){
            for(int i = n-1; i>=0; i--){
                if(left == 0){
                    break;
                }
                answer[i] += 1;
                left -=1;
            }            
        }


        return answer;
    }
}