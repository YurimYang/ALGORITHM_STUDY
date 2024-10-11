import java.util.*;
import java.io.*;

class Solution {
    static Queue<Word> queue = new LinkedList<>();
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        queue.offer(new Word(0,begin));
        
        int tmp = 0;
        for(String word : words){
            if(!word.equals(target)){
                tmp++;
            }
        }
        if(tmp == words.length){
            return 0;
        }

        answer = bfs(words, target);
        
        
        
        
        return answer;
    }
    
    public int bfs(String[] words, String target){
        while(!queue.isEmpty()){
            Word curr = queue.poll();
            
            if(curr.word.equals(target)){
                return curr.depth;
            }
            
            for(int i = 0; i<words.length; i++){
                if(onlyOneDiff(curr.word, words[i])){
                    queue.add(new Word(curr.depth + 1, words[i]));
                }
            }
        }
        return 0;
    }
    
    public boolean onlyOneDiff(String now, String before){
        int tmp = 0;
        for(int i = 0; i<now.length(); i++){
            if(now.charAt(i) != before.charAt(i)){
                tmp++;
            }
        }
        if(tmp == 1){
            return true;
        }
        return false;
    }
    
    
}

class Word{
    int depth;
    String word;
    
    public Word(int depth, String word){
        this.depth = depth;
        this.word = word;
    }
}