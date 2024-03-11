class Solution {
    public String solution(String[] seoul) {
        int spot = 0;
        for(int i = 0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                spot = i;
                break;
            }
        }
        String answer = "김서방은 " + spot +"에 있다";
        return answer;
    }
}