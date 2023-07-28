import java.io.*;
import java.util.*;

//1, 재료의 개수 : n
//2. 2개로 m이 되는지 check : 갑옷을 만드는데 필요한 수 : m
//3. n개의 재료들이 가진 고유한 번호들
// 2 7 4 1 5 3  => 2+7 || 4+5

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i =0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        //1 2 3 4 5 7
        
        int i = 0;
        int j = n-1;
        int ans = 0;

        while(i<j){
            if(arr[i]+arr[j] == m){
                ans++;
                i++;
                j--;
            }else if(arr[i] + arr[j] > m){
                j--;
            }else if(arr[i] + arr[j] < m){
                i++;
            }
        }
        System.out.println(ans);
    }
}
