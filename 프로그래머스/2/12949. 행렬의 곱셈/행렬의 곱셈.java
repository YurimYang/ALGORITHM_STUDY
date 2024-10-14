import java.util.*;
import java.io.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int width = arr2.length;
        int length = arr2[0].length;
        int[][] answer = new int[arr1.length][length];
        int idx = 0; 
        for(int[] arrOuter : arr1){
            for(int i = 0; i<length; i++){ 
                for(int j = 0; j<width; j++){
                    answer[idx][i] += arrOuter[j] * arr2[j][i];
                }     
            }
            idx++;
        }
        return answer;
    }
}
