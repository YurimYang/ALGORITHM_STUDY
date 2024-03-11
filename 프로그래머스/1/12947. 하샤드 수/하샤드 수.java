class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String[] numArr = String.valueOf(x).split("");
        int sum = 0;
        for(String num : numArr){
            sum += Integer.parseInt(num);
        }
        if(x % sum != 0){
            answer = false;
        }
        return answer;
    }
}