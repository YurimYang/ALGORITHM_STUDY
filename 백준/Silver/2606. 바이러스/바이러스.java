import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Main {
 
        static int N_com, N_conn;
        static int map[][];
        static int cnt;
        static int visited[];
        static Queue<Integer> q = new LinkedList<Integer>();
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            Scanner scan = new Scanner(System.in);
            
            N_com = scan.nextInt();
            N_conn = scan.nextInt();
            
            map = new int[N_com+1][N_com+1];
            visited = new int[N_com+1];
            
            for(int i=0;i<N_conn;i++) 
            {
                int a = scan.nextInt();
                int b = scan.nextInt();
                map[a][b] = map[b][a] = 1;    
            }
            
            bfs(1);
            System.out.println(cnt);
        }
        static void bfs(int start) 
        {
            
            q.offer(start);
            visited[start] = 1;
            
            while(q.isEmpty() == false) 
            {
                int current = q.poll();
                
                for(int i=1;i<N_com+1;i++)
                {
                    if(map[current][i] == 1 && visited[i] == 0)
                    {
                        q.offer(i);
                        visited[i] = 1;
                        cnt++;
                    }
                }
            }
        }
    }