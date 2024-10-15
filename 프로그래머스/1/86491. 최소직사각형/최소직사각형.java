class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        //가로 > 세로 일경우 변경하기
        for(int i = 0; i<sizes.length; i++){
            if(sizes[i][0] > sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        
        int a = 0;
        int b = 0;
        for(int i = 0; i<sizes.length; i++){
            a = Math.max(a, sizes[i][0]);
            b = Math.max(b, sizes[i][1]);
        }
        
        answer = a * b;
        
        return answer;
    }
}

