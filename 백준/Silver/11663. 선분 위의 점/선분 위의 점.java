import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] grid = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            grid[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(grid);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sIdx = Integer.parseInt(st.nextToken());
            int eIdx = Integer.parseInt(st.nextToken());
            sb.append(upperEnd(grid, eIdx) - lowerStart(grid, sIdx)).append('\n');
        }
        System.out.println(sb);

    }

    public static int lowerStart(int[] grid, int sIdx) {
        int low = 0;
        int high = grid.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (grid[mid] >= sIdx) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upperEnd(int[] grid, int eIdx){
        int low = 0;
        int high = grid.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (grid[mid] <= eIdx) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}