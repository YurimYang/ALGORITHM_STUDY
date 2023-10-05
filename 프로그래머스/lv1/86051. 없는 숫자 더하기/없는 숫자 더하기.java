class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] numList = {0,1,2,3,4,5,6,7,8,9};
        for(int num : numbers){
            if(numList[num] >= 0){
                numList[num] = -1;
            }
        }
        for(int num : numList){
            if(num != -1){
                answer += num;
            }
        }
        return answer;
    }
}