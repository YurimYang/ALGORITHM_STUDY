import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            String size = br.readLine();
            int w = Integer.parseInt(size.split(" ")[0]);
            int h = Integer.parseInt(size.split(" ")[1]);

            if (w == 0 && h == 0){
                break;
            }

            int[][] map = new int[h][w];
            int[][] visited = new int[h][w];

            int land = 0;

            for(int i = 0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visited[i][j] != 1 && map[i][j] == 1) {
                        bfs(map, visited, i, j);
                        land++;
                    }
                }
            }
            System.out.println(land);
        }



    }

    public static void bfs(int[][] map, int[][] visited, int x, int y){
        int[] dx = {0,-1,-1,-1,0,1,1,1};
        int[] dy = {-1,-1,0,1,1,1,0,-1};

        Queue<pointss> queue = new LinkedList<>();
        queue.offer(new pointss(x,y));
        visited[x][y] = 1;

        boolean isLandExist = false;

        while(!queue.isEmpty()){
            pointss cur = queue.poll();

            for(int i = 0; i<8; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canGo(nx, ny, map, visited)){
                    queue.offer(new pointss(nx, ny));
                    visited[nx][ny] = 1;
                }
            }
        }
    }

    public static boolean canGo(int x, int y, int[][] map, int[][] visited){
        if(!inRange(x, y, map[0].length, map.length)){
            return false;
        } else if(visited[x][y] == 1 || map[x][y] == 0){
            return false;
        }
        return true;
    }

    public static boolean inRange(int x, int y, int w, int h){
        return 0<=x && x<h && 0<=y && y<w;
    }
}

class pointss {
    int x;
    int y;

    public pointss(int x, int y){
        this.x = x;
        this.y = y;
    }
}
