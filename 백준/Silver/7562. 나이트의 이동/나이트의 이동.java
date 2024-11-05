import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int l, s1, s2, e1, e2, cnt = 0;
    static Queue<Point> queue = new LinkedList<>();
    static int[][] graph;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); //테스트 케이스 횟수
        for (int i = 0; i < n; i++) {
            cnt = 0;
            l = Integer.parseInt(br.readLine());
            graph = new int[l][l];
            visited = new int[l][l];
            st = new StringTokenizer(br.readLine());
            s1 = Integer.parseInt(st.nextToken());
            s2 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            e1 = Integer.parseInt(st.nextToken());
            e2 = Integer.parseInt(st.nextToken());

            if(isEnd(s1,s2)){
                sb.append(0).append("\n");
            } else {
                visited[s1][s2] = 1;
                bfs();
                sb.append(graph[e1][e2]).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void bfs() {
        queue = new LinkedList<>();
        queue.offer(new Point(s1, s2));
        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

        while(!queue.isEmpty()) {
            Point curr = queue.poll();

            for(int i = 0; i < 8; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(canGo(nx, ny)){
                    if(visited[nx][ny] == 0){
                        queue.offer(new Point(nx,ny));
                        graph[nx][ny] = graph[curr.x][curr.y] + 1;
                        visited[nx][ny] = 1;
                    }

                }
            }
        }
    }

    public static boolean canGo(int x, int y) {
        return 0 <= x && x<l && 0 <= y && y<l;
    }

    public static boolean isEnd(int x, int y){
        return x == e1 && y == e2;
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