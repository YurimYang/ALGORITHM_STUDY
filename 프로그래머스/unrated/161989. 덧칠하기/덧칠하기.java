class Solution {
    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] numArr = new int[n];
        for(int num : section){
            if(numArr[num-1] != 1){ //6+4-1 = 9
                if(num+m-1<n){
                    for(int i = num-1; i<num+m-1; i++){
                        numArr[i] = 1;
                    }
                }else{
                    for(int i = num-1; i<n;i++){
                        numArr[i] = 1;
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}