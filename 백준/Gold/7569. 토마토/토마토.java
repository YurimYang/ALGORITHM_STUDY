import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n, h, day = 0;
    static int[][][] graph;
    static int[][][] visited;
    static Queue<Point> startQueue = new LinkedList<Point>();
    static Queue<Point> queue = new LinkedList<Point>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); //상자의 가로 칸
        n = Integer.parseInt(st.nextToken()); //상자의 세로 칸
        h = Integer.parseInt(st.nextToken()); //상자의 수 (쌓아올려지는)

        graph = new int[h][n][m];
        visited = new int[h][n][m];

        for (int z = 0; z < h; z++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    graph[z][i][j] = Integer.parseInt(st.nextToken());
                    if (graph[z][i][j] == 1) {
                        startQueue.offer(new Point(z, i, j));
                    }
                }
            }
        }

        if (isAllDone()) {
            System.out.println(0);
        } else {
            bfs();
            if (isAllDone()) {
                System.out.println(day - 1);
            } else {
                System.out.println(-1);
            }
        }
    }


    public static void bfs() {
        int[] dh = {0, 0, 0, 0, -1, 1}; //상하좌우위아래
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};

        while (!startQueue.isEmpty()) {
            Point p = startQueue.poll();

            for (int i = 0; i < 6; i++) {
                int nh = p.h + dh[i];
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (outOfGraph(nh, nx, ny)) {
                    if(graph[nh][nx][ny] == 0) {
                        graph[nh][nx][ny] = graph[p.h][p.x][p.y] + 1;
                        startQueue.offer(new Point(nh, nx, ny));
                    }
                }
            }
        }
    }

    public static boolean outOfGraph(int hei, int x, int y) {
        return 0 <= hei && hei < h && 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean isAllDone() {
        for (int z = 0; z < h; z++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[z][i][j] == 0) {
                        return false;
                    } else {
                        day = Math.max(day, graph[z][i][j]);
                    }
                }
            }
        }
        return true;
    }
}


class Point {
    int h;
    int x;
    int y;

    public Point(int h, int x, int y) {
        this.h = h;
        this.x = x;
        this.y = y;
    }
}

