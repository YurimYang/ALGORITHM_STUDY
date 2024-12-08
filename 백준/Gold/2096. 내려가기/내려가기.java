import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[n+1][3];
        int[][] dpMin = new int[n+1][3];
        int[][] dpMax = new int[n+1][3];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i<=n; i++){
            dpMin[i][0] = num[i][0] + Math.min(dpMin[i-1][0], dpMin[i-1][1]);
            dpMin[i][1] = num[i][1] + Math.min(dpMin[i-1][0], Math.min(dpMin[i-1][1], dpMin[i-1][2]));
            dpMin[i][2] = num[i][2] + Math.min(dpMin[i-1][1], dpMin[i-1][2]);

            dpMax[i][0] = num[i][0] + Math.max(dpMax[i-1][0], dpMax[i-1][1]);
            dpMax[i][1] = num[i][1] + Math.max(dpMax[i-1][0], Math.max(dpMax[i-1][1], dpMax[i-1][2]));
            dpMax[i][2] = num[i][2] + Math.max(dpMax[i-1][1], dpMax[i-1][2]);
        }

        int min = Math.min(dpMin[n][0], Math.min(dpMin[n][1], dpMin[n][2]));
        int max = Math.max(dpMax[n][0], Math.max(dpMax[n][1], dpMax[n][2]));


        System.out.println(max + " " + min);
    }
}
