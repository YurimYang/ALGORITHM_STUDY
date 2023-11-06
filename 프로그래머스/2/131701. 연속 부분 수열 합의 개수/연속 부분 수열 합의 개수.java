import java.util.*;
class Solution {    
    public int solution(int[] elements) {
        int n = elements.length;
        int[] extendedElements = new int[2 * n];

        for (int i = 0; i < n; i++) {
            extendedElements[i] = elements[i];
            extendedElements[i + n] = elements[i];
        }

        int[] prefixSum = new int[2 * n + 1];
        for (int i = 0; i < 2 * n; i++) {
            prefixSum[i + 1] = prefixSum[i] + extendedElements[i];
        }

        HashSet<Integer> uniqueSums = new HashSet<>();
        for (int length = 1; length <= n; length++) {
            for (int i = 0; i < n; i++) {
                int sum = prefixSum[i + length] - prefixSum[i];
                uniqueSums.add(sum);
            }
        }

        return uniqueSums.size();
    }
}