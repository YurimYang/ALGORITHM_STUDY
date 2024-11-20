import java.util.*;
import java.io.*;

class Solution {
    int[][] arr;
    Queue<Integer> queue = new LinkedList<>();
    public int solution(int n, int[][] wires) {
        int answer = n;
        arr = new int[n+1][n+1];
        
        //인접행렬에 추가
        for(int i = 0; i< wires.length; i++){
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        
        //선을 끊으면서 순회
        for(int i = 0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            arr[a][b] = 0;
            arr[b][a] = 0;
            
            answer = Math.min(answer, bfs(n,a));
            
            arr[a][b] = 1;
            arr[b][a] = 1;
            
        }
        
        return answer;
    }
    
    public int bfs(int n, int start){
        int[] visit = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int cnt = 1;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            visit[now] = 1;
            
            for(int i = 1; i<=n; i++){
                if(visit[i] == 1){
                    continue;
                } 
                if(arr[now][i] == 1){
                    queue.add(i);
                    cnt++;
                }
            }
        }
        
        return (int) Math.abs(n - 2 * cnt); // cnt - (n-cnt) = cnt와 n-cnt개로 나뉘어 질 것. 
    }

}