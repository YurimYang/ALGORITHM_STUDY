class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long original =  x;
        for(int i = 0; i< n; i++){
            original += x * (long)i;
            answer[i] = original;
            original = x;
        }
        return answer;
    }
}