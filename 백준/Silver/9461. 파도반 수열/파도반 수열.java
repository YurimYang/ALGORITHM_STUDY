import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        long[] p = new long[101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        p[1] = p[2] = p[3] = 1;
        p[4] = p[5] = 2;

        int t = Integer.parseInt(br.readLine());

        for (int i = 6; i < 101; i++) {
            p[i] = p[i - 5] + p[i - 1];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(p[n]);
        }
    }
}