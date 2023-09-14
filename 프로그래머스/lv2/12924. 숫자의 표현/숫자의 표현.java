class Solution {
    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            for (int j = i; j <= n; j++) {
                tmp += j;
                if (tmp == n) {
                    answer++;
                    break;
                } else if(tmp > n){
                    break;
                }
            }
        }
        return answer;
    }
}