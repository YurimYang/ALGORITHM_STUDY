import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // target이 words에 없으면 변환 불가
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        // BFS를 위한 큐와 방문 여부를 기록할 Set
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        // 첫 시작 단어 삽입
        queue.add(new Node(begin, 0)); 
        visited.add(begin);
        
        // BFS 탐색
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            // target에 도달했으면 단계 수 리턴
            if (current.word.equals(target)) {
                return current.steps;
            }
            
            // 아직 도달하지 않았다면 변환 가능한 단어 탐색
            for (String word : words) {
                if (!visited.contains(word) && isChangeable(current.word, word)) {
                    visited.add(word);  // 방문 처리
                    queue.add(new Node(word, current.steps + 1));
                }
            }
        }
        
        // target에 도달할 수 없으면 0 리턴
        return 0;
    }
    
    // 두 단어가 한 글자만 다른지 확인
    private boolean isChangeable(String before, String after) {
        int diffCount = 0;
        for (int i = 0; i < before.length(); i++) {
            if (before.charAt(i) != after.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }
    
    // BFS 탐색을 위한 노드 클래스 (단어와 현재까지의 단계 수 저장)
    class Node {
        String word;
        int steps;
        
        Node(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
}
