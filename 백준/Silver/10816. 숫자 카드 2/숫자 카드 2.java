import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            hm.put(num,hm.getOrDefault(num,0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int j =0; j<m;j++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(hm.getOrDefault(key,0)+" ");
        }

        System.out.println(sb);

    }
}
