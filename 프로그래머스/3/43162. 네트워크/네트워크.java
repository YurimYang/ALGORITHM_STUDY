public class Solution {
  public int solution(int n, int[][] computers) {
    int answer = 0;
    boolean[] check = new boolean[n]; 

    // 연결되있는걸 다 돌고 와서 answer ++를 하다보니, 1-2 , 3이면 1-2 연결된걸 한개로 봐서 1만 추가되고, 3에서 1이 추가되서 결과적으로 답은 2가 된다.
    for (int i = 0; i < n; i++) {
      if (!check[i]) {
        dfs(computers, i, check);
        answer++;
      }
    }

    return answer;
  }

  boolean[] dfs(int[][] computers, int i, boolean[] check) {
    check[i] = true;

    for (int j = 0; j < computers.length; j++) {
      if (i != j && computers[i][j] == 1 && check[j] == false) {
        check = dfs(computers, j, check);
      }
    }
    return check;
  }

}