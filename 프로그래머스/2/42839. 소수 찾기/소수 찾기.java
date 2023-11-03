import java.util.*;
class Solution {
static Set<Integer> set;
    static boolean[] visited;
    static String[] part;
    public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        part = numbers.split("");

        permutation(0,"");
        for(int num : set){
            if(isPrimeNumber(num)){
                answer++;
            }
        }
        return answer;
    }

    public static void permutation(int idx, String sum) {
        if(!sum.isEmpty()){
            set.add(Integer.parseInt(sum));
        }
        for(int i = 0; i<part.length; i++){
            if(!visited[i]){
                visited[i]=true;
                permutation(idx+1, sum + part[i]);
                visited[i] = false;
            }
        }
    }


    public static boolean isPrimeNumber(int number){
        if(number <= 1){
            return false;
        }
        for(int i = 2; i<=Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}