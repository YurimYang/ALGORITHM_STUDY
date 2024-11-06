import java.util.*;
import java.io.*;
public class Main {

    static int[][] graph = new int[5][5];
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int i = 0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                dfs(i,j,new StringBuilder());
            }
        }

        System.out.println(set.size());
    }

    public static void dfs(int sx, int sy, StringBuilder number){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        if(number.toString().length() == 6){
            set.add(number.toString());
            return;
        }

        for(int i = 0; i<4; i++){
            int nx = sx + dx[i];
            int ny = sy + dy[i];

            if(canGo(nx, ny)){
                number.append(graph[nx][ny]);
                dfs(nx, ny, number);
                number.deleteCharAt(number.length()-1);
            }
        }
    }

    public static boolean canGo(int x, int y){
        return 0<=x && x<5 && 0<=y && y<5;
    }
}