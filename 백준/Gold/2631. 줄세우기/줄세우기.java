import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        lis[idx++] = arr[0];

        for (int i = 1; i < n; i++) {
            if (lis[idx - 1] < arr[i]) {
                lis[idx++] = arr[i];
            } else {
                int start = 0;
                int end = idx - 1;

                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (lis[mid] < arr[i]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

                lis[start] = arr[i];
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] > 0) {
                cnt++;
            }
        }

        System.out.println(n - cnt);
    }
}