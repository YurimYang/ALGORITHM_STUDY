import java.util.*;
class Solution {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num : tangerine){
            hm.put(num, hm.getOrDefault(num,0)+1);
        }
        List<Integer> list = new LinkedList<>(hm.values());
        list.sort((o1,o2) -> (o2.intValue() - o1.intValue())); // 내림차순
        for(int num : list){
            k-=num;
            answer++;
            if(k<1){
                break;
            }
        }
        return answer;
    }
}