import java.util.*;
import java.io.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static String[] dict = {"A", "E", "I", "O", "U"};
    static int answer = 0;
    public int solution(String word) {
        dfs(word, "", 0);
        
        return list.indexOf(word);
    }
    
    public void dfs(String word, String tmp, int depth){
        list.add(tmp);
        
        if(depth == 5){
            return;
        }
        
        for(int i = 0; i<dict.length; i++){
            dfs(word, tmp+dict[i], depth+1);    
        }
    }
}