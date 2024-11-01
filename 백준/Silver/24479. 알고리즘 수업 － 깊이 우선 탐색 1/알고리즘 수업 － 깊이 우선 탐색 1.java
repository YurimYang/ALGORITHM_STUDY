import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    static List<List<Integer>> graph;
    static int n,m,r,cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //정점의 수
        m = Integer.parseInt(st.nextToken()); //간선의 수
        r = Integer.parseInt(st.nextToken()); //시작정점
        visited = new int[n+1];
        graph = new ArrayList<>();

        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 1; i<=n; i++){
            Collections.sort(graph.get(i));
        }

        cnt = 1;
        dfs(r);

        for(int i = 1; i<visited.length; i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int start){
        visited[start] = cnt;
        for(int i =0; i<graph.get(start).size(); i++){
            int next =  graph.get(start).get(i);
            if(visited[next] == 0){
                cnt++;
                dfs(next);
            }
        }
    }
}