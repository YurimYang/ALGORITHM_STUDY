import java.util.*;
import java.io.*;

public class Main {
    static int answer, n, s = 0;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        num = new int[n];
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        countSum(0,0);

        if(s == 0){
            answer -= 1;
        }

        System.out.println(answer);
    }


    public static void countSum(int sum, int depth){
        if(depth == n) {
            if (sum == s) {
                answer++;
            }
            return;
        }
        countSum(sum+num[depth], depth+1);
        countSum(sum, depth+1);
    }
}