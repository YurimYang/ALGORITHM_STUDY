import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int len = answers.length;
        int[] newA = new int[len];
        int[] newB = new int[len];
        int[] newC = new int[len];
        
        int ansA = 0;
        int ansB = 0;
        int ansC = 0;
        
        int[] As = {1,2,3,4,5};
        int[] Bs = {2,1,2,3,2,4,2,5};
        int[] Cs = {3,3,1,1,2,2,4,4,5,5};


        for(int i = 0; i<len; i++){
            if(As[i%5] == answers[i]){
                ansA++;
            };
            if(Bs[i%8] == answers[i]){
                ansB++;
            }
            if(Cs[i%10] == answers[i]){
                ansC++;
            }
        }        
        
        int maxAnswer = 0;
        maxAnswer = Math.max(Math.max(ansA, ansB), ansC);
        
        if(maxAnswer == ansA){
            answer.add(1);
        } 
        if(maxAnswer == ansB){
            answer.add(2);
        }
        if(maxAnswer == ansC){
            answer.add(3);
        }

        return answer;
    }
}


//1번방식 : 1~5 나열 반복
//2번방식 : 2 + i 번 나열 반복
//3번방식 : 3 + 