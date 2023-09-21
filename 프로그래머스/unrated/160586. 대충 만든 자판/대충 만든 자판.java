import java.util.*;
class Solution {
    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character,Integer> map = new HashMap<>();

        for(String str : keymap){
            for(int i = 0; i<str.length(); i++) {
                map.put(str.charAt(i), Math.min(i+1, map.getOrDefault(str.charAt(i),
                    Integer.MAX_VALUE)));
            }
        }
        int j = 0;
        for(String str : targets){
            for(int i =0; i<str.length();i++){
                if(map.containsKey(str.charAt(i))){
                    answer[j] += map.get(str.charAt(i));
                }else{
                    answer[j] = -1;
                    break;
                }
            }
            j++;
        }


        return answer;
    }
}