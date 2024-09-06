import java.util.*;
import java.io.*;

class Solution {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(x);
        visited.add(x);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                int num = queue.poll();
                if(num == y){
                    return answer;
                }
                if(num + n <= y && !visited.contains(num + n)) {
                    queue.add(num+n);
                    visited.add(num+n);
                } 
                if(num * 2 <= y && !visited.contains(num * 2)) {
                    queue.add(num * 2);
                    visited.add(num * 2);
                }
                if(num * 3 <= y && !visited.contains(num * 3)) {
                    queue.add(num * 3);
                    visited.add(num * 3);
                }
            }
            answer++;
        }

        return -1;
    }
    
}
