import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Number> pq = new PriorityQueue<>(
            Comparator.comparingInt(o -> Math.abs(o.res)));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = n - 1;

        while (low < high) {
            int tmp = num[low] + num[high];
            pq.offer(new Number(num[low], num[high], tmp));
            if (tmp > 0) {
                high -= 1;
            } else {
                low += 1;
            }
        }

        Number answer = pq.poll();
        sb.append(answer.num1 + " " + answer.num2);

        System.out.println(sb);
    }
}

class Number {

    int num1;
    int num2;
    int res;

    public Number(int num1, int num2, int res) {
        this.num1 = num1;
        this.num2 = num2;
        this.res = res;
    }
}