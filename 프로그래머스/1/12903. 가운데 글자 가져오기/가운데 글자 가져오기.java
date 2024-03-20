class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length()/2;
        if(s.length() % 2 == 0){
            answer += s.charAt(len-1); 
        }
        answer += s.charAt(len);
        return answer;
    }
}