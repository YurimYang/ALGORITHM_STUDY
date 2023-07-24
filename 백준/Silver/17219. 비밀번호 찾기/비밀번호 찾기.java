import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Hashtable ht = new Hashtable();
        String str1 = sc.nextLine();
        String[] strArr1 = str1.split(" ");
        int n = Integer.parseInt(strArr1[0]);
        int m = Integer.parseInt(strArr1[1]);
        for (int i =0; i<n;i++){
            String str = sc.nextLine();
            String[] strArr = str.split(" ");
            ht.put(strArr[0], strArr[1]);
        }

        for(int j=0; j<m;j++){
            String str2 = sc.nextLine();
            System.out.println(ht.get(str2));
        }
    }
}