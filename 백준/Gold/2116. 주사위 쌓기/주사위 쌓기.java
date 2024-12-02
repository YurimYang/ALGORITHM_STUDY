import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] dice = new int[n][6];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < 6; i++) {
            int sum = 0;
            int down = dice[0][i];
            int top = dice[0][setTop(i)];

            for(int j = 0; j<n; j++){
                int max = 0;
                for(int k = 0; k<6; k++){
                    if(dice[j][k] == top){
                        down = top;
                        top = dice[j][setTop(k)];

                        max = findMaxNumberExceptTopDown(top, down);
                        break;
                    }
                }
                sum += max;
            }

            ans = Math.max(ans, sum);
        }

        System.out.println(ans);


    }

    public static int setTop(int idx) {
        if (idx == 0) {
            return 5;
        } else if (idx == 1) {
            return 3;
        } else if (idx == 2) {
            return 4;
        } else if (idx == 3) {
            return 1;
        } else if (idx == 4) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int findMaxNumberExceptTopDown(int top, int down) {
        int max = 0;
        for (int i = 1; i <= 6; i++) {
            if (i != down && i != top) {
                max = Math.max(max, i);
            }
        }
        return max;
    }
}
