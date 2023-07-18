import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        Stack<Integer> stk = new Stack<>();

        for(int i =0; i< k ; i++){
            int num = sc.nextInt();
            if(num == 0){
                if(stk.isEmpty()){
                    return;
                }
                stk.pop();
            }else{
                stk.push(num);
            }
        }

        int sum = 0;
        for(int n : stk){
            sum += n;
        }
        System.out.println(sum);

    }
}