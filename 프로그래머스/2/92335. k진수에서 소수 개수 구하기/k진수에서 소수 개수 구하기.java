import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        List<String> primeNumber = new ArrayList<>();
        String kNum = Integer.toString(n,k); //k진수로 변경
        //	211 0 2 0 1 0 1 0 11 = 211 , 2, 11 3개
        // 11 00 11 = 11, 11 2개
        
        StringBuilder sb = new StringBuilder();
        char[] prime = kNum.toCharArray();
        for(int i = 0; i<prime.length; i++){
            if(prime[i] - '0' != 0){
                sb.append(prime[i]);
            } else {
                if(!sb.toString().isEmpty()){
                    primeNumber.add(sb.toString());
                }
                sb = new StringBuilder();
            }
        }
        if (!sb.toString().isEmpty()) {
            primeNumber.add(sb.toString());
        }
        
        for(String p : primeNumber){
            if(isPrimeNumber(Long.parseLong(p))){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrimeNumber(long num){
        if(num < 2){
            return false;
        } 
        for(long i = 2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}