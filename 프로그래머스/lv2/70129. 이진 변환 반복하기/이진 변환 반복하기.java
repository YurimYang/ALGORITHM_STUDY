import java.util.LinkedList;
class Solution {
public int[] solution(String s) {
        int[] answer = {0,0};
        while (!s.equals("1")){
            char[] ch = s.toCharArray();
            LinkedList list = new LinkedList();
            for(char c : ch){
                if(c == '1'){
                    list.add(c);
                } else if(c == '0'){
                    answer[1] += 1;
                }
            }
            String binary = Integer.toBinaryString(list.size());
            s = binary;
            answer[0] +=1;
        }
        return answer;
    }
}