import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] answer;
    static int[] forCheck;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        //노드의 개수 : n : 6
        //선행 조건 개수 : m : 4
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n+1]; //0~n 학기까지 존재
        forCheck = new int[n+1]; //차수를 구하기 위한 리스트



        //처음에 연결 상태를 위한 Array
        graph = new ArrayList<>();

        //graph의 모든 노드에 먼저 연결할 arrayList 삽입해놓기
        for(int j = 0; j<=n;j++){
            graph.add(new ArrayList<>());
        }

        //이후에, 각 index별로 second 값 넣기
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph.get(first).add(second);
            forCheck[second]++;
        }

        topologicalSort();

        for(int k = 1; k <= n; k++){
            System.out.print(answer[k] + " ");
        }
    }

    public static void topologicalSort(){
        //실제 노드들을 위상정렬로 넣을 QUEUE
        Queue<Integer> queue = new LinkedList<>();

        //처음 진입차수가 0인 노드들 큐에 담기
        for(int i = 1; i<=n; i++){
            if(forCheck[i] == 0){
                queue.add(i);
                answer[i] = 1;
            }
        }

        while(!queue.isEmpty()){
            int num = queue.poll();

            for(int v : graph.get(num)){
                forCheck[v]--;

                if(forCheck[v] == 0){
                    queue.add(v);
                    answer[v] = answer[num]+1;
                }
            }
        }
    }
}
