import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        //여벌 체육복을 가져왔으나 도난 당함
        for(int i = 0; i<lost.length; i++){
            for(int j = 0; j< reserve.length; j++){
                if(lost[i] == reserve[j]){
                    reserve[j] = -100;
                    answer++;
                    lost[i] = -100;
                }
            }
        }
        
        for(int l : lost) {
            if(l < 0){
                continue;
            }
            int extraMinus = l-1;
            int extraPlus = l+1;
            if(l == 1){
                extraMinus = 0;
            }
            for(int i = 0; i< reserve.length; i++){
                if(reserve[i] < 0){
                    continue;
                }
                if(reserve[i] == extraMinus || reserve[i] == extraPlus){
                    answer++;
                    reserve[i] = -100;
                    break;
                }
            }   
        }
        return answer;
    }
}