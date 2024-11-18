import java.util.*;
import java.io.*;

class Solution {
    static int answer = 0;
    static int[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new int[dungeons.length];
        dfs(dungeons, k, visited, 0);
        return answer;
    }
    
    public void dfs(int[][] dungeons, int k, int[] visited, int depth){
        if(depth > answer){
            answer = depth;
        }
        for(int i = 0; i< dungeons.length; i++){
            if(visited[i] == 0 && k >= dungeons[i][0]){
                visited[i] = 1;
                dfs(dungeons, k-dungeons[i][1], visited, depth+1);
                visited[i] = 0;
            }
        }
        
    }
}