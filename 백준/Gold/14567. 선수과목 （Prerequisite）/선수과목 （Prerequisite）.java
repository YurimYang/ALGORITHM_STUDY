import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> l = new ArrayList<>();
    static int[] parentNum;
    static int[] answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parentNum = new int[N+1];
        answer = new int[N+1];
        for(int i = 0; i<=N; i++)
            l.add(new ArrayList<>());

        while(M-->0){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            l.get(A).add(B);
            parentNum[B]++;
        }

        topologicalSort();

        for(int i = 1; i<=N; i++)
            System.out.print(answer[i]+" ");
        System.out.println();
    }

    static void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i<=N; i++)
            if(parentNum[i] == 0){
                q.offer(i);
                answer[i] = 1;
            }

        while(!q.isEmpty()){
            int num = q.poll();

            for(int i : l.get(num)){
                parentNum[i]--;

                if(parentNum[i] == 0){
                    q.offer(i);
                    answer[i] = answer[num] + 1;
                }
            }
        }
    }
}