class Solution {
    
    public int solution(int n) {
        int answer = 0;
        int count = countOne(n);
        int index = 1;
        while(true){
            int number = n + index;
            if(count == countOne(number)){
                answer = number;
                break;
            }
            index++;
        }
        return answer;
    }
    
    public int countOne(int n){
        String binary = Integer.toBinaryString(n);
        char[] ch = binary.toCharArray();
        int cnt = 0;
        for(char c : ch){
            if(c == '1'){
                cnt +=1;
            }
        }
        return cnt;
    }
}