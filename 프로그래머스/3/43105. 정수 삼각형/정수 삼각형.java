import java.util.*;
import java.io.*;


//점화식 : dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        //1. 계산한 숫자들을 저장할 배열 생성
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        
        for(int i = 1; i<triangle.length; i++){
            //2. 가장 왼쪽 (j가 0인것들만 더해짐)
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            
            //3. 가장 오른쪽 (j가 triangle[i].length (=i) 인것들만 더해짐)
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
                  
            //4. 중앙자리
            for(int j = 1; j<= i; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }
        
        for(int i = 0; i< triangle.length; i++){
            answer = Math.max(dp[triangle.length - 1][i], answer);
        }

        return answer;
    }
}