import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] grid = new int[n];
        st = new StringTokenizer(br.readLine());
        int min = 0, max = 0;
        for (int i = 0; i < n; i++) {
            grid[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, grid[i]);
        }

        while (min < max) {
            long tmp = 0;
            int mid = (min + max) / 2;
            for (int num : grid) {
                if (num > mid) {
                    tmp += (num - mid);
                }
            }
            if (tmp < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
