class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i<absolutes.length; i++){
            if(signs[i] == false){
                answer += (absolutes[i] * -1);
            } else {
                answer += absolutes[i];
            }
            //answer += absolutes[i] * (signs[i]? 1: -1);
            
        }
        return answer;
    }
}

//absoulutes : 정수들의 절댓값
//signs : 정수들의 부호 (true : 양수, false : 음수)