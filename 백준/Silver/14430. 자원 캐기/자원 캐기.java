import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j<=m; j++){
                dp[i][j] = grid[i][j] + Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        System.out.println(dp[n][m]);
    }
}