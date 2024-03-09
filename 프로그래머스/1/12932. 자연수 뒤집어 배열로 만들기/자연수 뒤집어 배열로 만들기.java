import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class Solution {
    public static int[] solution(long n) {
        String result = String.valueOf(n);
        int[] answer = new int[result.length()];
        for(int i = result.length() -1; i>=0; i--){
            answer[result.length()-1-i] = result.charAt(i) - '0';
        }
        return answer;
    }
}