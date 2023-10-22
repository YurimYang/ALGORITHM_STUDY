import java.util.*;
class Solution {
    private static int[] dx = {-1, 1, 0, 0};//상하좌우
    private static int[] dy = {0, 0, -1, 1};//상하좌우


    public static List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if(!visited[i][j] && maps[i].charAt(j) != 'X'){
                    answer.add(BFS(i,j,maps,visited));
                }

            }
        }

        if(answer.isEmpty()){
            return new ArrayList<>(Arrays.asList(-1));
        }else{
            Collections.sort(answer);
            return answer;
        }



    }

    public static int BFS(int i, int j, String[] maps, boolean[][] visited){
        int total = 0; //각 섬에서 최대 머무를 수 있는 수
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i,j));
        visited[i][j] = true;

        while(!queue.isEmpty()){
            Point now = queue.poll();

            total += maps[now.x].charAt(now.y)-'0';
            for(int k = 0; k<4; k++){
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];

                if(nx < 0 || nx >= maps.length
                    || ny < 0 || ny >= maps[0].length()){
                    continue;
                } else {
                    if(!visited[nx][ny] && maps[nx].charAt(ny) != 'X'){
                        queue.add(new Point(nx,ny));
                        visited[nx][ny] = true;
                    }
                }


            }
        }

        return total;
    }

    static class Point{
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}