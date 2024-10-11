import java.util.*;
import java.io.*;

class Solution {
    static PriorityQueue<String> pq = new PriorityQueue<>();
    static int[] used;
    public String[] solution(String[][] tickets) {
        used = new int[tickets.length];
        
        dfs("ICN", tickets, 0, "ICN");
        String[] answer = pq.peek().split("->");
        
        return answer;
    }
    
    public void dfs(String from, String[][] tickets, int depth, String path){
        if(depth == tickets.length){
            pq.offer(path);
            return;
        }
        
        for(int i = 0; i<tickets.length; i++){
            if(used[i] == 0 && tickets[i][0].equals(from)){
                used[i] = 1;
                dfs(tickets[i][1], tickets, depth + 1, path + "->" + tickets[i][1]);
                used[i] = 0;
            }
        }
    }
}