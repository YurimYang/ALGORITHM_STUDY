import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n%3); //0021
            n = n/3; //15 5 1
        }
        answer = Integer.parseInt(sb.toString(),3);
        return answer;
    }
}
