import java.util.*;
import java.io.*;

class Solution {
    static int answer = 0;
    static int[] visited;
    public int solution(int[] numbers, int target) {
        visited = new int[numbers.length];
        dfs(numbers, target, 0, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int idx, int result, int depth){
        if(depth == numbers.length){
            if(result == target){
                answer++;
                return;
            }
        }
        
        if(idx >= numbers.length){
            return;
        }

        dfs(numbers, target, idx + 1, result + numbers[idx], depth + 1);
        dfs(numbers, target, idx + 1, result - numbers[idx], depth + 1);
        
    }
}