import java.util.*;
import java.io.*;


public class Main {

    static int n,m = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int nx = 0;
        int ny = 0;
        int dir = 0;

        boolean isOutOfRange = false;

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(command.equals("MOVE")){
                int moved;
                if(dir == 0){
                    moved = nx + num;
                    if(inRange(moved, ny)){
                        nx += num;
                    } else {
                        isOutOfRange = true;
                        break;
                    }
                } else if (dir == 1) {
                    moved = ny - num;
                    if(inRange(nx, moved)){
                        ny -= num;
                    } else {
                        isOutOfRange = true;
                        break;
                    }
                } else if (dir == 2) {
                    moved = nx - num;
                    if(inRange(moved, ny)) {
                        nx -= num;
                    } else {
                        isOutOfRange = true;
                        break;
                    }
                } else if (dir == 3) {
                    moved = ny + num;
                    if(inRange(nx, moved)){
                        ny += num;
                    } else {
                        isOutOfRange = true;
                        break;
                    }
                }
            } else if (command.equals("TURN")){
                if(num == 0){
                    dir = (dir + 3) % 4;
                } else if (num == 1){
                    dir = (dir + 1) % 4;
                }
            }
        }

        if(isOutOfRange){
            System.out.println(-1);
        } else {
            System.out.println(nx + " " + ny);
        }

    }

    public static boolean inRange(int x, int y){
        return 0 <= x && x < m && 0<=y && y<m;
    }
}