import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int i = 0;
        for(int num : arr){
            if(num % divisor == 0){
                i++;
            }
        }
        
        if(answer.length == 0 && i == 0){
            answer = new int[]{-1};
        } else {
            answer = new int[i];
            int j = 0;
            for(int num : arr){
                if(num % divisor == 0){
                    answer[j] = num;
                    j++;
                }
            }  
            Arrays.sort(answer);     
        }
        return answer;
    }
}