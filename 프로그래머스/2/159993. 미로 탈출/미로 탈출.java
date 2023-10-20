import java.util.*;
class Solution {
    private static int[] dx = {-1,1,0,0};//상하좌우
    private static int[] dy = {0,0,-1,1};//상하좌우

    public static int solution(String[] maps) {
        int answer = 0;
        int toLever = 0;
        int toExit = 0;
        Moving start = findPosition(maps,'S');
        Moving lever = findPosition(maps,'L');
        Moving exit = findPosition(maps,'E');

        toLever = bfs(maps, start, lever);
        toExit = bfs(maps,lever,exit);
        if(toLever != -1 && toExit != -1){
            answer = toLever + toExit;
        }else {
            answer = -1;
        }



        return answer;
    }

    public static int bfs(String[] maps, Moving start, Moving target){
        Queue<Moving> movingQueue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        movingQueue.add(start);
        visited[start.x][start.y] = true;

        while(!movingQueue.isEmpty()){
            Moving tmp = movingQueue.poll();
            int x = tmp.x;
            int y = tmp.y;
            int time = tmp.time;

            if(x == target.x && y == target.y){
                return time;
            } else {
                for(int i = 0; i<4 ; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx>=0 && nx < maps.length
                        && ny >=0 && ny < maps[0].length()
                        && !visited[nx][ny]){
                        if(maps[nx].charAt(ny) != 'X'){
                            visited[nx][ny] = true;
                            movingQueue.add(new Moving(nx,ny,time+1));
                        }

                    }
                }
            }

        }
        
        return -1;
    }

    public static Moving findPosition(String[] maps, char find){
        for(int i = 0; i<maps.length; i++){
            for(int j = 0; j<maps[0].length(); j++){
                char ch = maps[i].charAt(j);
                if(ch == find)
                    return new Moving(i, j, 0);
            }
        }
        return null;
    }

    static class Moving{
        int x,y,time;
        public Moving(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}