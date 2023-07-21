import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt(); // 버퍼의 크기
        Queue<Integer> q = new LinkedList<Integer>();
        while(true){ //-1이 아닐때까지 로직 진행
            int packet = sc.nextInt();
            if(packet == 0){
                q.poll(); //처음에 들어갔던 것이 삭제됨 !!
                n++;
            }else if(packet == -1){
                break;
            }else {
                if (n > 0) {
                    q.add(packet);
                    n--;
                }
            }
        }
        if(q.isEmpty()){
            System.out.println("empty");
        }else{
            int size = q.size();
            for(int i =0; i<size;i++){
                sb.append(q.poll());
                if(i<size-1){
                    sb.append(" ");
                }
            }
            System.out.println(sb);

        }
    }
}
