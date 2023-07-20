import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        for (int j = 1; j <= n ; j++){
            q.add(j);
        }

        if (n == 1){
            System.out.println(1);
        }else{
            for (int i=0; i< 2*n-3; i++){
                q.poll();
                if(q.size() > 1){
                    q.offer(q.peek());
                    q.poll();
                } else{
                    System.out.println(q.peek());
                    break;
                }
            }
        }
    }
}
