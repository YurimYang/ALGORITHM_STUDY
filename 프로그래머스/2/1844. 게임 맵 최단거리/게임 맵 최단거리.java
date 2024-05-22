import java.util.*;
import java.io.*;

class Solution {
    static int[][] visited, step;
    static int n, m;
    static Queue<Point> queue = new LinkedList<>();
    public int solution(int[][] maps) {
        int answer = -1;
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        step = new int[n][m];
        
        //첫번째 초기화
        queue.add(new Point(0,0));
        visited[0][0] = 1;
        
        
        BFS(maps);
        
        if(step[n-1][m-1] > 0){
            answer = step[n-1][m-1] +1;
        } 
         
        return answer;
    }
    public void BFS(int[][] maps){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        while(!queue.isEmpty()){
            Point currP = queue.poll();
            for(int i = 0; i<4; i++){
                int nx = currP.x + dx[i];
                int ny = currP.y + dy[i];
                
                if(canGo(nx, ny, maps)){
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = 1;
                    step[nx][ny] = step[currP.x][currP.y] + 1; 
                }
            }
        }
    }
    
    public boolean canGo(int x, int y, int[][] maps){
        if(!inRange(x,y)){
            return false; 
        } 
        if(visited[x][y] != 0 || maps[x][y] == 0){
            return false;
        }
        return true;
    }
    
    public boolean inRange(int x, int y){
        return 0<=x && x<n && 0 <=y && y<m;
    }
}

class Point{
    int x;
    int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}