class Solution {
    private static int answer = 0;

    public static int solution(int k, int[][] dungeons) {
        int[] visited = new int[dungeons.length];
        DFS(k,0,visited,dungeons);

        return answer;
    }

    public static void DFS(int k, int count,int[] visited, int[][] dungeons){ //80,20
        if(count > answer){
            answer = count;
        }
        for(int i = 0; i<dungeons.length; i++) {
            if (k >= dungeons[i][0] & visited[i] == 0) {
                visited[i] = 1;
                DFS(k - dungeons[i][1], count + 1, visited, dungeons);
                visited[i] = 0;
            }
        }
    }
}