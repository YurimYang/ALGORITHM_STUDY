import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> aPoint = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> bPoint = new PriorityQueue<>((o1, o2) -> o2 - o1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            aPoint.offer(Integer.parseInt(st.nextToken()));
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            bPoint.offer(Integer.parseInt(st.nextToken()));
        }


        if (n % 2 == 1 && !aPoint.isEmpty()) {
            answer += aPoint.poll();
        }

        for (int i = 0; i < n / 2; i++) {
            int tmpA = 0;
            int tmpB = 0;
            if (aPoint.size() >= 2) {
                int aFirst = aPoint.poll();
                int aSecond = aPoint.poll();
                tmpA = aFirst + aSecond;
                aPoint.offer(aFirst);
                aPoint.offer(aSecond);
            }
            if (bPoint.size() >= 1) {
                tmpB = bPoint.peek();
            }

            if (tmpA > tmpB) {
                answer += tmpA;
                aPoint.poll();
                aPoint.poll();

            } else {
                answer += tmpB;
                bPoint.poll();
            }
        }
        System.out.println(answer);
    }
}
