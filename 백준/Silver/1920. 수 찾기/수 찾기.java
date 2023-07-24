import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        HashSet hs = new HashSet<>();
        for (int i=0; i<n;i++){
            hs.add(sc.nextInt());
        }
        int m = sc.nextInt();
        for(int j=0; j < m;j++){
            if(hs.contains(sc.nextInt())){
                sb.append("1\n");
            }else{
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}