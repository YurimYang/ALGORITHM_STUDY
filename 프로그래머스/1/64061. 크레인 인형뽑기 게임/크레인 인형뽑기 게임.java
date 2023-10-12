import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
class Solution {
public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int dollNum = 0;
        Stack<Integer> storage = new Stack<>();
        Map<Integer, Stack<Integer>> AllStorageMap = new HashMap<>();



        for (int i = 0; i < board.length; i++) {
            Stack<Integer> dollStk = new Stack<>();
            for (int j = board[0].length-1; j >=0; j--) {
                dollStk.push(board[j][i]);
            }
            AllStorageMap.put(i + 1, dollStk);
        }

        for (int num : moves) {
            Stack<Integer> targetStk = new Stack<>();
            targetStk = AllStorageMap.get(num);
            if(targetStk.isEmpty()){
                break;
            } else {
                while(true){
                    if(!targetStk.isEmpty()){
                        dollNum = targetStk.peek();
                    }
                    if(dollNum!= 0){
                        break;
                    }
                    targetStk.pop();
                }
                targetStk.pop();
                if(storage.isEmpty() ||storage.peek()!= dollNum ){
                    storage.push(dollNum);
                } else {
                    storage.pop();
                    answer+=2;
                }

                AllStorageMap.put(num, targetStk);
            }
        }

        return answer;
    }
}