import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        // PriorityQueue<Word> pq = new PriorityQueue<>((o1,o2)->{
        //     int headCompare = o1.head.compareToIgnoreCase(o2.head); //head기준 오름차순
        //     if(headCompare == 0){
        //         int first = Integer.parseInt(o1.number);
        //         int second = Integer.parseInt(o2.number);
        //         if(first == second){
        //             return o1.idx - o2.idx;
        //         }
        //         return first-second;
        //     }
        //     return headCompare;
        // });
        
        List<Word> list = new ArrayList<>();

        for(int i = 0; i<files.length; i++){
            String head = files[i].split("[0-9]")[0].toLowerCase();
            String left = files[i].substring(head.length());
            String number = validateNumber(left);

            list.add(new Word(i,head, number,files[i]));
            
        }
        
        Collections.sort(list);
        
        int idx = 0;
        for(int i = 0; i<list.size(); i++){
            Word word = list.get(i);
            answer[i] = word.full;
        }

        return answer;
    }
    
    public String validateNumber(String number){
        StringBuilder sb = new StringBuilder();
        for (char c : number.toCharArray()) {
            // 숫자이고 길이가 5를 넘어가지 않는다면
            if (Character.isDigit(c) && sb.length() < 5) {
                sb.append(c);
            } else {
                return sb.toString();
            }
        }
 
        return sb.toString();
    }
}

class Word implements Comparable<Word>{
    int idx; 
    String head;
    String number;
    String full;
    
    public Word(int idx, String head, String number, String full){
        this.idx = idx;
        this.head = head;
        this.number = number;
        this.full = full;
    }
    
    @Override
    public int compareTo(Word w) {
        int headCompare = this.head.compareTo(w.head); //head기준 오름차순
            if(headCompare == 0){
                int first = Integer.parseInt(this.number);
                int second = Integer.parseInt(w.number);
                if(first == second){
                    return this.idx - w.idx;
                }
                return first-second;
            }
            return headCompare;
    }
    
}