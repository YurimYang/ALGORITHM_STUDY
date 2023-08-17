import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  //동전 종류 개수
        int k = Integer.parseInt(st.nextToken());  //가치의 합
        int[] coins = new int[n];  //동전 값들
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            if (k / coins[i] > 0) {
                count += (k/coins[i]);
                k -= (k/coins[i])*coins[i];
            }
        }
        System.out.print(count);
    }
}
