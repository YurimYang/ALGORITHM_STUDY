import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int[] sum = new int[3];
        
        int len = answers.length;
        for(int i = 0; i< len; i++){
            if(answers[i] == a[i % 5]){
                sum[0]++;
            } 
            if(answers[i] == b[i%8]){
                sum[1]++;
            }
            if(answers[i] == c[i%10]){
                sum[2]++;
            }
        }
        
        int max = 0;
        for(int i = 0; i<3; i++){
           max = Math.max(max, sum[i]);
        }
        
        if(max == sum[0]){
            answer.add(1);
        }
        if(max == sum[1]){
            answer.add(2);
        }
        if(max == sum[2]){
            answer.add(3);
        }
        

        
        
        return answer;
    }
}