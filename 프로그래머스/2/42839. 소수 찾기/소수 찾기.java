import java.util.*;
import java.io.*;

// 소수 판단 함수 + dfs 방식으로 찾는 함수를 구현 
// dfs 함수를 구현할 때, String값을 Integer로 변경하여 찾을 수 잇는 값 전부를 중복없이 리스트에 담기
// 리스트에 담긴 값들을 소수판단하여 세준다

class Solution {
    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[] check = new boolean[7]; //최대 7자리수
    

    public int solution(String numbers) {
        int answer = 0;
        
        for(int i = 0; i<numbers.length(); i++) {
            dfs(numbers, "", i+1);
        }
        
        for(int i = 0; i<arr.size(); i++){
            if(isPrime(arr.get(i))){
                answer++;
            }
        }
        
        return answer;
        
        
    }
    
    //dfs를 활용한 백트래킹 방법
    public void dfs(String str, String tmp, int m) {
        
        if(tmp.length() == m){
            int num = Integer.parseInt(tmp);
            if(!arr.contains(num)){
                arr.add(num);
            }
        }
        
        
        for(int i = 0; i<str.length(); i++){
            if(!check[i]){
                check[i] = true;
                tmp += str.charAt(i);
                dfs(str,tmp, m);
                check[i] = false;
                tmp = tmp.substring(0, tmp.length()-1);
            }
        }
        
    }
    
    public boolean isPrime(int num) {
        
        if(num < 2){
            return false;
        }
        
        for(int i = 2; i<= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}