import java.util.*;
import java.io.*;

class Solution {
    static List<int[]> splitList = new ArrayList<>();
    static HashMap<Integer, int[]> splitMap = new HashMap<>();
    static Set<Integer> nonDuplicateSet = new LinkedHashSet<>();

    public List<Integer> solution(String s) {
        List<Integer> answer;
        int maxLen = init(s);
        for(int i = 1; i<=maxLen; i++){
            int[] tmpArr = splitMap.get(i);
            for(int j = 0; j<tmpArr.length; j++){
                nonDuplicateSet.add(tmpArr[j]);
            }
        }
        answer = new ArrayList<>(nonDuplicateSet);
        return answer;
    }
    
    
    
    public int init(String s){
        s.substring(1, s.length() - 1); //앞뒤 분리
        String[] groups = s.split("\\},\\{");
        int maxLen = Integer.MIN_VALUE;
        for(String group : groups){
            group = group.replaceAll("[{}]", "");
            String[] numbers = group.split(",");
            int numLen = numbers.length;
            maxLen = Math.max(maxLen, numLen); 
            int[] tmpArr = new int[numLen];
            for(int i = 0; i<numLen; i++){
                tmpArr[i] = Integer.parseInt(numbers[i].trim());
            }
            splitMap.put(numLen, tmpArr);
        }
        return maxLen;
    }
}