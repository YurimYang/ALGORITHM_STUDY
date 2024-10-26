import java.util.*;
import java.io.*;

//DFS로 풀기 
class Solution {
    static HashSet<HashSet<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        
        dfs(user_id, banned_id, new HashSet<>(), 0);
        return result.size();
    }
    
    public void dfs(String[] user_id, String[] banned_id, HashSet<String> set, int depth){
        if (depth == banned_id.length){
            result.add(set);
            return;
        }
        
        for(int i = 0; i< user_id.length; i++){
            if(set.contains(user_id[i])) {
                continue;
            }
            
            if(check(user_id[i], banned_id[depth])){
                set.add(user_id[i]);
                dfs(user_id, banned_id, new HashSet<>(set), depth + 1);
                set.remove(user_id[i]);
            }
        }
    }
    
    
    public boolean check(String userId, String bannedId){
        if(userId.length() != bannedId.length()){
            return false;
        }
        
        boolean match = true;
        for(int i = 0; i<userId.length(); i++){
            if(bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)){
                match = false;
                break;
            }
        }
        
        return match;
    }
}

//user_id
// ["frodo", "fradi", "crodo", "abc123", "frodoc"]


// //banner_id
// ["fr*d*", "*rodo", "******", "******"]
// fr*d* = frodo, fradi
// *rodo = frodo, crodo
// ****** = abc123, frodoc
// ****** = abc123, frodoc 
// 2 * 2 - 1 
    
// frodo = fra*d*, *rodo
// fradi = fra*d*
// crodo = *rodo
// abc123 = ******
// frodoc = ******
