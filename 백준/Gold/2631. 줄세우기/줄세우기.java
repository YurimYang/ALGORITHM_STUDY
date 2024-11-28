import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] children = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }

        int maximum = 0;
        for (int i = 0; i < n; i++) {
            int max = dp[i];
            for (int j = 0; j < i; j++) {
                if (children[i] > children[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    max = children[j];
                }
            }
            maximum = Math.max(maximum, dp[i]);
        }

        System.out.println(n - maximum);
    }
}