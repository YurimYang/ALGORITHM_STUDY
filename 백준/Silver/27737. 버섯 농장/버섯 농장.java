import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][n];
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isChanged = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && visited[i][j] == 0) {
                    double size = bfs(i, j, visited, grid);
                    size = (int) Math.ceil(size / k);
                    m -= size;
                    isChanged = true;
                }
            }
        }

        if(isChanged && m >=0){
            System.out.println("POSSIBLE");
            System.out.println(m);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static double bfs(int x, int y, int[][] visited, int[][] grid) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        visited[x][y] = 1;

        int size = 1;
        while(!queue.isEmpty()){
            Point cur = queue.poll();

            for(int i = 0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canGo(nx, ny, grid, visited)){
                    visited[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    size++;
                }
            }
        }
        return size;
    }

    public static boolean canGo(int x, int y, int[][] grid, int[][] visited){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
            return false;
        } else if(grid[x][y] == 1 || visited[x][y] == 1){
            return false;
        }
        return true;
    }
}


class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}