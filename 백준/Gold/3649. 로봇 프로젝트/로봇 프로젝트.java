import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine())!=null) {
            int X = Integer.parseInt(str)*10000000;
            int N = Integer.parseInt(br.readLine());
            int[] legos = new int[N];
            for(int i=0; i<legos.length; i++) legos[i] = Integer.parseInt(br.readLine());
            Arrays.sort(legos);
            int s = 0, e = N-1;
            boolean flag = false;
            while(s<e) {
                int sum = legos[s]+legos[e];
                if(sum==X) {
                    flag = true;
                    break;
                }
                else if(sum<X) s++;
                else e--;
            }
            if(flag) System.out.println("yes "+legos[s]+" "+legos[e]);
            else System.out.println("danger");
        }
    }
}
