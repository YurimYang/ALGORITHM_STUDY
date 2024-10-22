import java.util.*;
import java.io.*;

class Solution {
    static int[] ans;
    static int[][] ansArr;
    static int[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    public int solution(int[][] land) {
        int answer = 0;
        visited = new int[land.length][land[0].length];
        ansArr = new int[land.length][land[0].length];
        ans = new int[land[0].length];
        for(int i = 0; i< land.length; i++){
            for(int j = 0; j<land[0].length; j++){
                if(land[i][j] == 1 && visited[i][j] == 0){
                    visited[i][j] = 1;
                    queue.offer(new Point(i,j));
                    bfs(land);
                }
            }
        }
        
        for(int i = 0; i<ans.length; i++){
            answer = Math.max(answer, ans[i]);
        }

        return answer;
    }
    
    public void bfs(int[][] land){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        int count = 1;
        Set<Integer> set = new HashSet<>();
        set.add(queue.peek().y);
        while(!queue.isEmpty()){
            Point curr = queue.poll();
            
            for(int i = 0; i<4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(canGo(nx, ny, land)){
                    count++;
                    visited[nx][ny] = 1;
                    queue.offer(new Point(nx,ny));
                    set.add(ny);
                } 
            }

        }
        
        for(int c : set){
            ans[c] += count;
        }
    }
    
    public boolean canGo(int x, int y, int[][] land){
        if(!inRange(x,y,land)){
            return false;
        } else if(visited[x][y] == 1 || land[x][y] == 0){
            return false;
        }
        return true;
    }
    
    public boolean inRange(int x, int y, int[][] land){
        return 0 <= x && x <land.length && 0<=y && y< land[0].length;
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

//bfs로 문제풀기

