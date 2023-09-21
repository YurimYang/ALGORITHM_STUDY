import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        Map<Character,Integer> mapX = new HashMap<>();
        Map<Character,Integer> mapY = new HashMap<>();
        
        for(char chX : X.toCharArray()){
            mapX.put(chX,mapX.getOrDefault(chX,0)+1);
        }
        for(char chY : Y.toCharArray()){
            mapY.put(chY,mapY.getOrDefault(chY,0)+1);
        }
        for(char c : mapX.keySet()){
            if(mapY.containsKey(c)){
                for(int i = 0; i<Math.min(mapX.get(c),mapY.get(c)); i++){
                    list.add(c);
                }
            }
        }
        if(list.isEmpty()){
            return  "-1";
        }
        Collections.reverse(list);
        for(char c : list){
            sb.append(c);
        }
        answer = sb.toString();
        if(answer.replaceAll("0","").isEmpty()){
            return "0";
        }
        return answer;
    }
}
