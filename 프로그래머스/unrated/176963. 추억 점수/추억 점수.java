import java.util.HashMap;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i<name.length; i++){
            hm.put(name[i],yearning[i]);
        }
        int i = 0;
        for(String[] string : photo){
            for(String str : string){
                if(hm.containsKey(str)){
                    answer[i] += hm.get(str);
                }
            }
            i++;
        }
        return answer;
    }
}