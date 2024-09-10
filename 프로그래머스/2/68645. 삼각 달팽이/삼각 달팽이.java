import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n) {
        int max = n*(n+1)/2; //등비수열 합
        int[] answer = new int[max];
        int[][] arr = new int[n][n];
        
        // 시작 지점
        int x = -1;
        int y = 0;
        int num = 1;
        
        for(int i = 0; i<n; ++i){
            for(int j =i; j<n; ++j){
                if(i % 3 == 0) {
                    ++x;
                } else if (i % 3 == 1) {
                    ++y;
                } else if (i % 3 == 2) {
                    --x;
                    --y;
                }
                arr[x][y] = num++;
            }
        }
        
        int idx = 0;
        for(int i =0; i<arr.length; i++){
            for(int j = 0; j<=i; j++){
                answer[idx] = arr[i][j];
                idx++;
            }
        }

        
        return answer;
    }
}