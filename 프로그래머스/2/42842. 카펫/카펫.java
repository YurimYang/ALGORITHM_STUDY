import java.util.LinkedList;
import java.util.List;
class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int width, height = 0;
        int size = brown + yellow;
        // 갈색 박스 = (노란박스의 세로 + 노란박스의 가로) * 2 + 4 (각 테두리의 꼭짓점)
        
        for(int i = 3; i< size; i++){ //i = 노란색의 세로길이, j = 노란색의 가로길이 (모두 3 이상)
            int j = size / i;
            
            if(j >=3 && size % i == 0){
                if(i>j) break;
                
                if ((i+j) * 2 - 4 == brown) {
                    answer[0] = j;
                    answer[1] = i;
                    return answer;
                }
            }
        }
        return answer;
    }
}