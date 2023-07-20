import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt(); //테스트케이스의 수

        sc.nextLine(); //개행문자 소비

        while(num!=0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            LinkedList<int[]> q = new LinkedList<>();
            for (int i=0;i<n;i++){
                q.offer((new int[] {i,sc.nextInt()}));
                //{초기위치, 중요도}
            }
            int cnt = 0;
            while(!q.isEmpty()){
                int[] front = q.poll();
                boolean isMax = true;

                for(int i = 0;i<q.size();i++){
                    if(front[1]<q.get(i)[1]) {
                        q.offer(front);
                        for(int j=0;j<i;j++){
                            q.offer(q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }

                if(isMax == false){
                    continue;
                }

                cnt++;
                if(front[0] == m){
                    break;
                }
            }

            num--;
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}
