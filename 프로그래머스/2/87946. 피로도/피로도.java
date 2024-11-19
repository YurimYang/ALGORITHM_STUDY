import java.util.*;
import java.io.*;

class Solution {
    static int answer = 0;
    static int[] visited; 
    public int solution(int k, int[][] dungeons) {
        visited = new int[dungeons.length];
        dfs(dungeons, 0, k);
        
        return answer;
    }
    public void dfs(int[][] dungeons, int result, int k){
        if(result > answer){
            answer = Math.max(answer,result);
            return;
        }
            
        for(int i = 0; i<dungeons.length; i++){
            if(visited[i] == 0 && k - dungeons[i][0] >= 0){
                visited[i] = 1;
                k -= dungeons[i][1];
                result += 1;
                dfs(dungeons, result, k);
                result -= 1;
                k += dungeons[i][1];
                visited[i] = 0;
            } 
        }
    }
}