class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        //약수 구하는 공식
        for(int i = left; i<=right; i++){
            int cnt = 0;
            for(int j = i; j>0; j--){
                if(i%j == 0){
                    cnt++;
                }
            }
            System.out.println(i + " " + cnt);
            if(cnt % 2 == 0){
                answer += i;
            } else {
                answer -=i;
            }
        }
        
        return answer;
    }
}
//left 부터 right까지 모든 수들 중에서 
//약수의 개수가 짝수인 수는 더하고 약수의 개수가 홀수인 수를 뺀수를 return