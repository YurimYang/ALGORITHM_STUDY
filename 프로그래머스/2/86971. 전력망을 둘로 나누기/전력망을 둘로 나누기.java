import java.util.*;
import java.io.*;

class Solution {
    static int[][] graph;
    static int[] visited;
    static int cnt = 0;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        //2차원 배열에 송전탑 연결 정보 담기
        graph = new int[n+1][n+1];
        for(int i = 0; i<wires.length; i++){
            int x = wires[i][0];
            int y = wires[i][1]; 
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        
        
        //송전탑을 하나씩 끊으면서 완전탐색 진행
        for(int i = 0; i<wires.length; i++){
            int x = wires[i][0];
            int y = wires[i][1]; 
            graph[x][y] = 0;
            graph[y][x] = 0;
            
            visited = new int[n+1];
            cnt = 0;
            dfs(x);
            int cnt1 = cnt;
            
            
            
            visited = new int[n+1];
            cnt = 0;
            dfs(y);
            int cnt2 = cnt;
            
            answer = Math.min(answer, Math.abs(cnt1 - cnt2));
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        return answer;
    }
    
    public void dfs(int start){
        visited[start] = 1;
        for(int j = 1; j<graph.length; j++){
            if(graph[start][j] > 0 && visited[j] == 0){
                cnt++;
                dfs(j);
            }
        }
    }
}