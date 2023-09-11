import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
class Solution
{
    public int solution(int []A, int []B) {
        int answer = 0;
        PriorityQueue<Integer> a = new PriorityQueue<Integer>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0; i<A.length; i++){
            a.add(A[i]);
            b.add(B[i]);
        }
        for(int i = 0; i<A.length;i++){
            answer += a.poll()*b.poll();
        }
        return answer;
    }
}