import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] fir = br.readLine().toCharArray();
        int firLen = fir.length;
        char[] sec = br.readLine().toCharArray();
        int secLen = sec.length;
        int ans = lcs(fir,sec,firLen,secLen);
        System.out.println(ans);
    }
    public static int lcs(char[] fir, char[] sec,int firLen, int secLen){
        int[][] lcs = new int[firLen+1][secLen+1];
        for(int i =0;i<=firLen;i++){
            for(int j =0; j<=secLen; j++){
                if(i == 0|| j == 0){
                    lcs[i][j] = 0;
                } else if (fir[i-1] == sec[j-1]){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }
        return lcs[firLen][secLen];
    }
}