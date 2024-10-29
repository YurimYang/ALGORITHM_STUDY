import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            long n = Long.parseLong(br.readLine());

            long start = 1;
            long end = 1000000000;

            long answer = 0;

            while(start <= end){
                long middle = (start + end) / 2;
                if(middle * (middle+1) / 2 <= n) {
                    answer = middle;
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
            System.out.println(answer);
        }
    }
}