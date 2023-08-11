import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static Queue<int[]> pq;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //도시의 개수
        int m = Integer.parseInt(st.nextToken()); //도로의 개수
        int k = Integer.parseInt(st.nextToken()); //도시간 거리 정보
        int x = Integer.parseInt(st.nextToken()); //출발 도시의 번호

        //그래프생성
        graph = new ArrayList<>();
        for(int i =0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph.get(first).add(second);
        }

        //거리만 담은 list생성
        int[] dist = new int[n+1];
        for(int i =0; i<dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[x] = 0;

        //PQ생성
        pq = new LinkedList<int[]>();
        pq.add(new int[] {x,0});

        while(!pq.isEmpty()){
            int[] target = pq.poll();

            int idx = target[0]; //1 - 2 - 3
            int dst = target[1]; //0 - 1 - 1


            for(int v : graph.get(idx)){ //2,3 //3,4 // 0 //0
                if(dist[v] > dist[idx] + 1){
                    dist[v] = dist[idx] + 1;
                    pq.add(new int[] {v,dist[v]});
                }
            }

        }
        int answer = 0;
        for(int i =0; i<dist.length;i++){
            if(dist[i] == k){
                System.out.println(i);
                answer++;
            }
        }
        if(answer == 0){
            System.out.println(-1);
        }

    }
}
