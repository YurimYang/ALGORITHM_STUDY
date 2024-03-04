import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String number = Integer.toString(n);
        for(int i = 0; i<number.length(); i++){
            answer += (int) (number.charAt(i) - '0');
        }
        return answer;
    }
}