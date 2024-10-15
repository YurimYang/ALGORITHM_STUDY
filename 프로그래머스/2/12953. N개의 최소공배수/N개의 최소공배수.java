import java.util.*;
import java.io.*;


class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        for(int i = 0; i<arr.length-1; i++){
            arr[i+1] = (arr[i] * arr[i+1]) / gcd(arr[i], arr[i+1]);
        }
        answer = arr[arr.length-1];
        return answer;
    }
    
    public int gcd(int i, int j){
        if(i%j == 0){
            return j;
        }
        return gcd(j, i%j);
    }
}
