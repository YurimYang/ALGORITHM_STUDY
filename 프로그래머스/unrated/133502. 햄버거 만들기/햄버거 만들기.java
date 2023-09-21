import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int chk = 1;
        Stack<Integer> stk = new Stack<>();
        for(int num : ingredient){
            if(stk.size() >=3 && num == 1){
                if(stk.get(stk.size()-1) == 3 &&
                  stk.get(stk.size()-2) == 2 &&
                  stk.get(stk.size()-3) == 1){
                    stk.pop();
                    stk.pop();
                    stk.pop();
                    answer++;
                }else{
                    stk.push(num);
                }
            }else{
                stk.push(num);
            }
        }
        return answer;
    }
}

//빵 - 야채 - 고기 -  빵
// 1 - 2  -  3  -  1

