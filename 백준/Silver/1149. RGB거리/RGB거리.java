import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n+1][3];
        int[][] dp = new int[n+1][3];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i<=n; i++){
            dp[i][0] = rgb[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = rgb[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = rgb[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }


        int answer = Math.min(dp[n][0], dp[n][1]);
        answer = Math.min(answer, dp[n][2]);

        System.out.println(answer);
    }
}