import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static String solution(String s){
        StringBuilder sb = new StringBuilder();
        String answer = " ";
        String[] strArr = s.split(" ");
        ArrayList<Integer> intArr = new ArrayList();
        int maxNum = 0;
        int minNum = 0;
        for(String str : strArr){
            int i = Integer.parseInt(str);
            intArr.add(i);
        }
        Collections.sort(intArr);
        minNum = intArr.get(0);
        maxNum = intArr.get(intArr.size()-1);
        sb.append(minNum+ " ").append(maxNum);
        answer = sb.toString();

        return answer;
    }
}