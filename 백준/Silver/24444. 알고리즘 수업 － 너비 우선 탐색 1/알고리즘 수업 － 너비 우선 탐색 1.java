import java.util.*;
import java.io.*;

public class Main {
    static int n,m,r = 0;
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;
    static int cnt = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new int[n+1];

        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(r).add(v);
            graph.get(v).add(r);
        }

        for(int i = 1; i<=n; i++){
            Collections.sort(graph.get(i));
        }

        queue.offer(r);
        visited[r] = 1;
        bfs();

        for(int i = 1; i<=n; i++){
            System.out.println(visited[i]);
        }


    }

    public static void bfs(){
        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int i = 0; i<graph.get(cur).size(); i++){
                int next = graph.get(cur).get(i);
                if(visited[next] == 0){
                    cnt++;
                    visited[next] = cnt;
                    queue.offer(next);
                }
            }
        }
    }
}