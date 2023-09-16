import java.util.*;
class Solution {
    public static int solution(int[] arr) {
        int answer = 0;
        Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());
        Stack<Integer> stk = new Stack<>();
        for (Integer elm : array) {
            stk.push(elm);
        }
        while(stk.size() != 1){
            int first = stk.pop();
            int second = stk.pop();
            int lcd = (first * second) / GCD(first,second);
            stk.push(lcd);
        }
        return stk.pop();
    }

    public static int GCD(int first, int second){
        //최대공약수
        while(first!=0){
            int tmp = first;
            first = second % first;
            second = tmp;
        }
        return second;
    }
}