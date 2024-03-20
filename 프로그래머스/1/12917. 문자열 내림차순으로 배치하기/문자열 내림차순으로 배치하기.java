import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        Character[] slist = new Character[s.length()];
        for(int i = 0; i<s.length(); i++){
            slist[i] = s.charAt(i);
        }
        Arrays.sort(slist, Collections.reverseOrder());
        for(int i = 0; i<slist.length; i++){
            answer += slist[i];
        }
        return answer;
    }
}