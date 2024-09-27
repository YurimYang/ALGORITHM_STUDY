import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxX = 0; //가로
        int maxY = 0; //세로
        for(int[] size : sizes) {
            maxX = Math.max(maxX, Math.max(size[0], size[1]));
            maxY = Math.max(maxY, Math.min(size[0], size[1]));
        }
        
    
        answer = maxX * maxY;
        
        

        return answer;
    }
    

}