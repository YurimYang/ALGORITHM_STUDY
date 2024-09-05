import java.util.*;
import java.io.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String tree : skill_trees){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<tree.length(); i++){
                char curr = tree.charAt(i);
                if(skill.contains(curr + "")){
                    sb.append(curr);
                }
            }
            answer += skill.indexOf(sb.toString())==0 ? 1:0;
            
        }
        return answer;
    }
}




//CDABF : CBD의 원칙에 어긋나므로 틀림
//0 3 1