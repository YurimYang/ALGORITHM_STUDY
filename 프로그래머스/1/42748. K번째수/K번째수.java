import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] intArr : commands){
            List<Integer> subList = new ArrayList<>();
            for(int j = intArr[0] - 1; j<intArr[1]; j++){
                subList.add(array[j]);
            }
            Collections.sort(subList);
            answer[idx++] = subList.get(intArr[2]-1);
            
        }
        return answer;
    }
}