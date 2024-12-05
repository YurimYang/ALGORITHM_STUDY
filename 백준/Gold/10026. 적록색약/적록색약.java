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

        int n = Integer.parseInt(br.readLine());

        String[][] gridDiff = new String[n][n]; //적록색약 x
        String[][] gridDiffNo = new String[n][n]; //적록색약 o
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                String color = String.valueOf(line.charAt(j));
                gridDiff[i][j] = color;
                if (color.equals("G")) {
                    gridDiffNo[i][j] = "R";
                } else {
                    gridDiffNo[i][j] = color;
                }
            }
        }

        String[] color = {"R", "G", "B"};
        int redGreenDiff = 0; //적록색약 x
        for (String c : color) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (gridDiff[i][j].equals(c) && visited[i][j] == 0) {
                        bfs(i, j, gridDiff, visited);
                        redGreenDiff++;
                    }
                }
            }
        }

        color = new String[]{"R", "B"};
        visited = new int[n][n];
        int redGreenSame = 0; //적록색약 o
        for (String c : color) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (gridDiffNo[i][j].equals(c) && visited[i][j] == 0) {
                        bfs(i, j, gridDiffNo, visited);
                        redGreenSame++;
                    }
                }
            }
        }


        System.out.print(redGreenDiff + " " + redGreenSame);


    }

    public static void bfs(int x, int y, String[][] grid, int[][] visited) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<GridPoint> queue = new LinkedList<>();
        queue.offer(new GridPoint(x, y));
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            GridPoint cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (canGo(nx, ny, grid, visited, grid[cur.x][cur.y])) {
                    queue.offer(new GridPoint(nx, ny));
                    visited[nx][ny] = 1;
                }
            }
        }
    }

    public static boolean canGo(int x, int y, String[][] grid, int[][] visited, String color) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        } else if (visited[x][y] == 1 || !grid[x][y].equals(color)) {
            return false;
        }
        return true;
    }

}

class GridPoint {
    int x;
    int y;

    public GridPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
