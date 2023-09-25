class Solution {
    public static int solution(int[][] board) {
        int answer = 0;
        int[] dx = {-1,-1,0,1,1,1,0,-1};//8좌표
        int[] dy = {0,1,1,1,0,-1,-1,-1};//8좌표
        int cnt = 0;

        int size = board.length;
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                if(board[i][j] == 1){
                    cnt++;
                    for(int k = 0; k<8 ; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >=0 && nx<size &&
                            ny >=0 && ny<size &&
                            board[nx][ny] == 0){
                            cnt++;
                            board[nx][ny] = 2;
                        }
                    }
                }

            }
        }
        answer = size * size - cnt;

        return answer;
    }
}