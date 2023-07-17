import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int index = 0;

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.offer(i);
        }
        System.out.print("<");
        while (!list.isEmpty()) {
            index = (index + (m - 1)) % list.size();
            if(list.size() != 1) {
                System.out.print(list.remove(index) + ", ");
            }else{
                System.out.print(list.remove(index));
            }
        }
        System.out.print(">");

    }
}