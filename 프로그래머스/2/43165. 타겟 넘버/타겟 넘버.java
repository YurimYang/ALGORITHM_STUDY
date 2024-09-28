import java.util.*;
import java.io.*;

//dfs로 풀기 
class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(target, numbers, 0, 0);
        
        return answer;
    }
    
    public void dfs(int target, int[] numbers, int idx, int sum){
        
        if(idx == numbers.length){
            if(sum == target){
                answer++;
            }
        }
        
        if(idx >= numbers.length){
            return;
        }
        
        dfs(target, numbers, idx+1, sum+numbers[idx]);
        dfs(target, numbers, idx+1, sum-numbers[idx]);

        
    }
}