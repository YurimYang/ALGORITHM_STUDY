import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
		int answer = 0;

		int[][] arr = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
		int size = Arrays.stream(picks).sum();
		List<Mineral> list = new ArrayList<>();

		for(int i = 0; i < minerals.length; i+=5) {
			if(size == 0) {
				break;
			}

			int diamond = 0;
			int iron = 0;
			int stone = 0;

			for(int j = i; j < i + 5; j++) {
				if(j == minerals.length) {
					break;
				}

				int mineral = 0;
				if(minerals[j].startsWith("i")) {
					mineral = 1;
				} else if(minerals[j].startsWith("s")) {
					mineral = 2;
				}

				diamond += arr[0][mineral];
				iron += arr[1][mineral];
				stone += arr[2][mineral];
			}
			list.add(new Mineral(diamond, iron, stone));
			size--;
		}

		list.sort(((o1, o2) -> (o2.stone - o1.stone)));
        
        for(Mineral m : list) {
			int diamond = m.diamond;
			int iron = m.iron;
			int stone = m.stone;

			if(picks[0] > 0) {
				answer += diamond;
				picks[0]--;
				continue;
			}

			if(picks[1] > 0) {
				answer += iron;
				picks[1]--;
				continue;
			}

			if(picks[2] > 0) {
				answer += stone;
				picks[2]--;
			}
		}
        
		return answer;
	}

	class Mineral {
		private int diamond;
		private int iron;
		private int stone;

		public Mineral(int diamond, int iron, int stone) {
			this.diamond = diamond;
			this.iron = iron;
			this.stone = stone;
		}
	}
}