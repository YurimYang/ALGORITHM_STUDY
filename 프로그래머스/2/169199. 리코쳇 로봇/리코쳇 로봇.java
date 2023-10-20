import java.util.*;
class Solution {
    private final static int[] dx = {-1, 1, 0, 0};
    private final static int[] dy = {0, 0, -1, 1};
    //D : 장애물 위치, G : 목표지점, R : 로봇 처음 위치

    public static int solution(String[] board) {
        int answer = 0;

        int x_size = board.length; //row (행)
        int y_size = board[0].length(); //column(열)
        boolean[][] visited = new boolean[x_size][y_size];

        Moving start = findPosition('R', board);
        Moving target = findPosition('G', board);

        answer = bfs(board, start, target, visited);

        return answer;
    }

    public static int bfs(String[] board, Moving start, Moving target, boolean[][] visited) {
        Queue<Moving> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        while (!queue.isEmpty()) {
            Moving check = queue.poll();
            if(check.x == target.x && check.y == target.y){
                return check.depth;
            }
            for (int i = 0; i < 4; i++) {
                int nx = check.x;
                int ny = check.y;

                while (nx >= 0 && nx < board.length &&
                    ny >= 0 && ny < board[0].length() &&
                    board[nx].charAt(ny) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                nx-=dx[i];
                ny-=dy[i];

                if(visited[nx][ny] || (check.x == nx && check.y == ny)){
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new Moving(nx,ny,check.depth+1));
            }
        }
        return -1;
    }

    public static Moving findPosition(char find, String[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                char ch = board[i].charAt(j);
                if (ch == find) {
                    return new Moving(i,j,0);
                }
            }
        }
        return null;
    }

    static class Moving {
        int x, y, depth;

        public Moving(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}