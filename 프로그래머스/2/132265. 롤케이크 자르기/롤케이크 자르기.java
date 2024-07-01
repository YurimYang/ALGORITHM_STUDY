import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 각 토핑의 개수를 세기 위한 맵
        HashMap<Integer, Integer> lCnt = new HashMap<>();
        HashMap<Integer, Integer> rCnt = new HashMap<>();
        
        // 처음에 오른쪽 맵을 채운다
        for (int t : topping) {
            rCnt.put(t, rCnt.getOrDefault(t, 0) + 1);
        }
        
        // 한 칸씩 이동하면서 왼쪽 맵과 오른쪽 맵을 업데이트
        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];
            
            // 왼쪽 맵에 추가
            lCnt.put(t, lCnt.getOrDefault(t, 0) + 1);
            
            // 오른쪽 맵에서 제거
            if (rCnt.get(t) == 1) {
                rCnt.remove(t);
            } else {
                rCnt.put(t, rCnt.get(t) - 1);
            }
            
            // 두 맵의 키셋의 크기가 같다면 정답 증가
            if (lCnt.keySet().size() == rCnt.keySet().size()) {
                answer++;
            }
        }
        
        return answer;
    }
}
