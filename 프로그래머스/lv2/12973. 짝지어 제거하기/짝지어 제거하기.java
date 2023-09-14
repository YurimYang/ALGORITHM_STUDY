import java.util.Stack;
class Solution
{
        public static int solution(String s) {
        String[] strArr = s.split("");
        Stack<String> stk = new Stack<>();
        for(String st : strArr){
            if(!stk.isEmpty() && stk.peek().equals(st)){
                stk.pop();
            } else {
                stk.push(st);
            }
        }
        if(stk.isEmpty()){
            return 1;
        } else {
            return 0;
        }
    }
}