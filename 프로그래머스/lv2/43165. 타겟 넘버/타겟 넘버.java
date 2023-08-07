class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0,0,target);
        return answer;
    }
        private void dfs(int[] numbers, int idx, int sum, int target){
        if(sum==target && idx == numbers.length){
            answer++;
            return;
        }

        if(idx >= numbers.length){
            return;
        }

        dfs(numbers,idx+1,numbers[idx]+sum, target);
        dfs(numbers, idx+1, -numbers[idx]+sum, target);

    }
}