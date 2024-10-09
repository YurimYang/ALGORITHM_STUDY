import java.util.*;
import java.io.*;

class Solution {
    static String[] alpha = {"A","E","I","O","U"};
    static List<String> list= new ArrayList<>();
    public int solution(String word) {
        dfs(word, "", 0);
        return list.indexOf(word);
    }
    
    public void dfs(String word, String tmp, int depth){
        list.add(tmp);
        if(depth == 5){
            return;
        }
        
        for(int i = 0; i<5; i++){
            dfs(word, tmp+alpha[i], depth + 1);
        }
        
    }
}