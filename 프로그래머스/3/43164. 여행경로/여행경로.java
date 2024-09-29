import java.util.*;
import java.io.*;

class Solution {
    static Queue<String> pq = new PriorityQueue<>();
    static int[] visited;
    public String[] solution(String[][] tickets) {
        visited = new int[tickets.length];
        
        dfs("ICN", tickets, 0, "ICN");
        String[] answer = pq.peek().split("->");
        
        
        return answer;
    }
    
    public void dfs(String from, String[][] tickets, int depth, String path) {
        if(depth == tickets.length){
            pq.offer(path);
            return;
        }
        for(int i = 0; i< tickets.length; i++){
            if(visited[i] == 0 && tickets[i][0].equals(from)){
                visited[i] = 1;
                dfs(tickets[i][1], tickets, depth + 1, path + "->" + tickets[i][1]);
                visited[i] = 0;
            }
        }
        
    }
}

