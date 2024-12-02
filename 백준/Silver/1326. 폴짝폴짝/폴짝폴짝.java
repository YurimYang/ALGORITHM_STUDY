import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] stones;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 1;

        n = Integer.parseInt(br.readLine());

        stones = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i<n+1; i++){
            stones[i] = Integer.parseInt(st.nextToken());
        }

        String[] ab = br.readLine().split(" ");

        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);

        System.out.println(bfs(a,b));

    }

    public static int bfs(int start, int end){
        int[] visited = new int[n+1];

        visited[start] = 1;

        Queue<Frog> queue = new LinkedList<>();

        queue.offer(new Frog(start, 0));

        while(!queue.isEmpty()){
            Frog frog = queue.poll();

            if(frog.pos == end){
                return frog.cnt;
            }

            int jump = stones[frog.pos];

            //앞으로가는경우
            for(int i = frog.pos; i< n+1; i+= jump){
                if(visited[i] == 1){
                    continue;
                }
                visited[i] = 1;
                queue.offer(new Frog(i, frog.cnt+1));
            }

            //뒤로가는경우
            for(int i = frog.pos; i>=1; i-= jump){
                if(visited[i] == 1){
                    continue;
                }
                visited[i] = 1;
                queue.offer(new Frog(i, frog.cnt + 1));
            }

        }
        return -1;

    }
}

class Frog {
    int pos;
    int cnt;

    public Frog(int pos, int cnt){
        this.pos = pos;
        this.cnt = cnt;
    }
}
