import java.util.*;
class Solution {
public static int[] solution(int[] arr){
        int[] answer = new int[arr.length];
        Stack<Integer> s = new Stack<>();
      
        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty()){
                if(s.peek() > arr[i]){
                    answer[i] = s.peek();
                    break;
                }else{
                    s.pop();
                }
            }
            if(s.isEmpty()){
                answer[i] = -1;
            }
            s.push(arr[i]);
        }
        return answer;
    }
}