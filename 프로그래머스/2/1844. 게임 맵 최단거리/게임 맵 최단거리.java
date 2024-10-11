import java.util.*;
import java.io.*;

class Solution {
    static int[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1,1,0,0}; 
    static int[] dy = {0,0,-1,1};
    static int answer = 0;
    static int n, m = 0;
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        n = maps.length;
        m = maps[0].length; 
        visited[0][0] = 1;
        queue.offer(new Point(0,0));
        bfs(maps);
        if(visited[n-1][m-1] == 0){
            return -1;
        }
        return visited[n-1][m-1];
    }
    
    public void bfs(int[][] maps){
        while(!queue.isEmpty()){
            Point curr = queue.poll();
            
            for(int i = 0; i<4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if(canGo(maps, nx, ny)){
                    visited[nx][ny] = visited[curr.x][curr.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }
    
    public boolean canGo(int[][] maps, int x, int y){
        if(!inRange(x, y)){
            return false;
        } else if(maps[x][y] == 0 || visited[x][y] > 0){
            return false;
        }
        return true;
    }
    
    public boolean inRange(int x, int y){
        return 0 <= x && x<n && 0<=y && y <m;
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