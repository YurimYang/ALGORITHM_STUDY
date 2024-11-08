import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;

        String[] hamburger = br.readLine().split("");

        for(int i = 0; i<n; i++){
            if(hamburger[i].equals("P")){
                for(int j = i-k; j<=i+k; j++) {
                    if (j >= 0 && j < n) {
                        if (hamburger[j].equals("H")) {
                            hamburger[j] = "E";
                            answer++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}