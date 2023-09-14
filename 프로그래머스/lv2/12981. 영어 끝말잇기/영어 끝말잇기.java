import java.util.*;

class Solution {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int round = 1;
        List<String> dict = new LinkedList<>();

        Queue<String> q = new LinkedList<>(Arrays.asList(words));
        String before = q.remove();
        dict.add(before);
        int index = 1;

        while (!q.isEmpty()) {
            if (index == n) {
                index = 0;
                round++;
            }

            index++;
            String now = q.remove();

            char lastC = before.charAt(before.length() - 1);
            if (now.charAt(0) != lastC || dict.contains(now)) {
                answer[0] = index;
                answer[1] = round;
                return answer;
            }

            before = now;
            dict.add(now);
        }


        return answer;
    }
}