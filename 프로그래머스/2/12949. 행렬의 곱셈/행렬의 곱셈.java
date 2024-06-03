import java.util.*;
import java.io.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int idx = 0;
        //int[] reArr2 = new int[arr2.length * arr2[0].length];
        
//         for(int i = 0; i<arr2.length; i++){
//             for(int j = 0; j<arr2[0].length; j++){
//                 reArr2[idx] = reArr2[j][i];
//                 idx++;
//             }
//         }
        
//         for(int[] arrOuter : arr1){
//             for(int num : reArr2){
//                 answer[]
//             }
//         }
        
        
        
        for(int[] arrOuter : arr1){
            for(int i = 0; i<arr2[0].length; i++){ 
                for(int j = 0; j<arr2.length; j++){
                    answer[idx][i] += arrOuter[j] * arr2[j][i];
                }     
            }
            idx++;
        }
        return answer;
    }
}
