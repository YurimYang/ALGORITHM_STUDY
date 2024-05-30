import java.util.*;
import java.io.*;

class Solution {
    static String[] alpha = new String[]{"A", "E", "I", "O", "U"};
    static List<String> wordList = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        
        dfs(word, "", 0);
        
        for(int i = 0; i<wordList.size(); i++){
            if(wordList.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public void dfs(String word, String line, int depth){
        wordList.add(line);
        
        if(depth == 5){
            return;
        }
        
        for(int i = 0; i<alpha.length; i++){

            dfs(word, line+alpha[i], depth+1);
        }
    }
}


		