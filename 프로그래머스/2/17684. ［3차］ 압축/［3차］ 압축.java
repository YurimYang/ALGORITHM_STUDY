import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, Integer> wordMap = new HashMap<>();
    static List<Integer> answer = new ArrayList<>();
    static int idx = 0;
    static String w, c = "";
    public List<Integer> solution(String msg) {
        init();
        rotate(msg);
        return answer;

    }
    
public static void rotate(String msg){
        while(idx < msg.length()){
            w = String.valueOf(msg.charAt(idx));
            int step = 0;
            boolean found = false;

            for(int j = idx+1; j<msg.length(); j++){
                c = String.valueOf(msg.charAt(j));
                String wc = w + c;
                step += 1;
                if(wordMap.containsKey(wc)){
                    w = wc;
                } else{
                    answer.add(wordMap.get(w));
                    wordMap.put(wc, wordMap.size() + 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                answer.add(wordMap.get(w));
                idx += step + 1; // 마지막에 도달했을 경우를 고려하여 idx를 증가시킴
            } else {
                idx += step;
            }
        }
    }

    public static void init(){
        for(int i = 0; i<26; i++){
            wordMap.put(String.valueOf((char)('A' + i)), i+1);
        }
    }
}