import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String>[] hs = new HashSet[501];
        for(int i =1; i<501;i++){
            hs[i] = new HashSet<>();
        }

        for(int i =0;i<n;i++){
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            //b a e k j o  n o n l i ne j u d g e
            //b (0)
            //ba (1)
            //bae (2)
            for(int j = 0; j<str.length();j++){
                sb.append(str.charAt(j));
                hs[sb.length()].add(sb.toString());
            }
        }
        int ans = 0;
        while(m-->0){
            String str = br.readLine();
            if(hs[str.length()].contains(str)){
                ans++;
            }
        }
        System.out.println(ans);
    }


}
