import java.util.*;
import java.io.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> str1List = toMultipleArr(str1);
        List<String> str2List = toMultipleArr(str2);
        
        
        HashMap<String, Integer> hm1 = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();
        
        for(String str : str1List){
            hm1.put(str, hm1.getOrDefault(str, 0) + 1);
        }
        for(String str : str2List){
            hm2.put(str, hm2.getOrDefault(str, 0) + 1);
        }
        
        int same = 0;
        if(hm1.size() > hm2.size()){
            same = getSameArr(hm1, hm2);
        } else {
            same = getSameArr(hm2, hm1);
        }
        System.out.println(str1List);
        System.out.println(str2List);
        
        if(str1List.size() == 0 && str2List.size() == 0){
            return 65536;
        }
        
        int sumCount = str1List.size() + str2List.size() - same;
        answer = (int) (((double) same/sumCount) * 65536);

        System.out.println((double) same/sumCount);
        System.out.println(sumCount);
        
        
        
        return answer;
    }
    
    //다중집합 만들기
    //FRANCE = FR RA AN NC CE
    //공백, 숫자, 특수문자 글자쌍 제외
    //aa1+aa2 = aa a1 1+ +a aa a2 => a1, 1+, +a, a2 제외
    public List<String> toMultipleArr(String str){
        str = str.toLowerCase();
        List<String> multipleList = new ArrayList<>();
        for(int i = 0 ; i<str.length()-1; i++){
            char first = str.charAt(i);
            char second = str.charAt(i+1);
            
            if(first - '0' > 48 && second - '0' > 48){
                multipleList.add(String.valueOf(first) + String.valueOf(second));
            }
        }
        return multipleList;
    }
    
    //교집합 개수세기
    public int getSameArr(HashMap<String, Integer> hm1, HashMap<String,Integer> hm2){
        int sameCount = 0;
                
        for(String key : hm1.keySet()){
            if(hm2.containsKey(key)){
                sameCount += Math.min(hm1.get(key), hm2.get(key));
            }
        }
        return sameCount;
    }
    
    //합집합 = str1 + str2 - 교집합 
    
}

//J(A,B) = A교B / A합B
//A, B = 공집합 => 1
//다중집합 = 두글자씩 끊어서 

