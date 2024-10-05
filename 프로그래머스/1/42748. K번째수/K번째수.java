import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIdx = 0;
        for(int[] command : commands){
            int s = command[0];
            int e = command[1];
            int idx = command[2];
            
            int[] newArr = Arrays.copyOfRange(array,s-1,e);
            Arrays.sort(newArr);
            answer[answerIdx] = newArr[idx-1];
            answerIdx++;
        }
        return answer;
    }
}