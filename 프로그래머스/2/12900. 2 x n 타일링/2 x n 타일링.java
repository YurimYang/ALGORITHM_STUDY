class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        
        for(int i = 2; i<n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n-1];
    }
}

    