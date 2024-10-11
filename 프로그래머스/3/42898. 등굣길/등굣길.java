import java.util.*;
import java.io.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        // dp 초기화
        int[][] dp = new int[n][m];
        
        dp[0][0] = 1;
        
        // 물웅덩이 dp에 표시
        for(int[] puddle : puddles){
            dp[puddle[1]-1][puddle[0]-1] = -1;
        }

        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                
                if (i != 0){
                    dp[i][j] += dp[i-1][j] % 1000000007;
                }
                
                if(j != 0){
                    dp[i][j] += dp[i][j-1] % 1000000007;
                }
            }
        }
        
        return dp[n-1][m-1] % 1000000007;
    }
}