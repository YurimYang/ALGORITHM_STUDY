import java.util.*;

public class Solution {
    public static int solution(int n) {
        int ans = 1;
        while (n>=2) {
            if (n == 2) {
                break;
            } else if (n % 2 == 0) {
                n = n / 2;
            } else {
                n -= 1;
                ans += 1;
            }
        }
        return ans;
    }
}