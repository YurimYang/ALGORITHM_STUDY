import java.util.*;
import java.io.*;

class Solution {
    static char[][] boards; //이중배열
    static boolean[][] erasedBoard; // nullCount배열
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        //String[][] 이중 배열로 생성
        boards = new char[m][n];
        erasedBoard = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boards[i][j] = board[i].charAt(j);
            }
        }
        
        //while로 계속 돌면서 폭파되지 않을때까지 진행
        while(true){
            erasedBoard = new boolean[m][n];
            for(int i = 0; i< m-1; i++){
                for(int j = 0; j< n-1; j++){
                    eraseBlock(i,j);
                }
            }
            
            int count = countErasedBlock(m,n);
            System.out.println(count);
            if(count == 0){
                break;
            }
            answer += count;
            getBlockDown(m,n);

        }
        
        return answer;
       
    
    }
    
    //폭파 가능한지 확인하기
    //(x,y) => (x,y+1), (x+1, y) (x+1,y+1) 이 같아야함
    public void eraseBlock(int x, int y){
        char lu = boards[x][y];
        char ru = boards[x][y+1];
        char ld = boards[x+1][y];
        char rd = boards[x+1][y+1];
        
        
        if(lu == ru && lu == ld && lu == ld && lu == rd){
            erasedBoard[x][y] = true;
            erasedBoard[x][y+1] = true;
            erasedBoard[x+1][y] = true;
            erasedBoard[x+1][y+1] = true;
        }
    }
    
    //true 개수 카운트하기
    public int countErasedBlock(int m, int n){
        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(!erasedBoard[i][j]){
                    continue;
                }
                if(erasedBoard[i][j] && boards[i][j] != '-'){
                    count++;
                    boards[i][j] = '-';
                }
            }
        }
        return count;
    }

    //박스 내려오기
    public void getBlockDown(int m, int n){
        for(int i = m-1; i>=0; i--){
            for(int j = 0; j<n; j++){
                if(boards[i][j] != '-'){
                    continue;
                }
                if(boards[i][j] == '-'){
                    for(int k = i-1; k >=0; k--){
                        if(boards[k][j] != '-'){
                            boards[i][j] = boards[k][j];
                            boards[k][j] = '-';
                            break;
                        }
                    }
                }
            }
        }
    }
}

// CCBED  CCBED  nnnED
// AAADE  nnnDE  nnnDE
// AAABF  nnnBF  nnnnF
// CCBBF  CCBBF  nnnnF