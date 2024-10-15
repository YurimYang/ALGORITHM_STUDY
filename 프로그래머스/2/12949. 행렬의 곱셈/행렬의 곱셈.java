class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        // 행렬 곱셈 로직
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int z = 0; z < arr1[0].length; z++) {
                    answer[i][j] += arr1[i][z] * arr2[z][j];
                }
            }
        }
        
        
        return answer;
    }
}