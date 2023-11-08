import java.util.*;
class Solution {
    public static ArrayList<int[]> list = new ArrayList<int[]>();
    public static int max_diff = -1;
    static int[] lionInfo = new int[11];
    static int[] peachInfo = new int[11];
    public static int[] solution(int n, int[] info) {
        int[] answer = {};

        peachInfo = info;

        DFS(n,0,0);

        // 만약 우승 가능성이 없다면 -1
        if(max_diff == -1){
            return new int[]{-1};
        }

        Collections.sort(list,(o1,o2)->{
            for(int i = 10; i>= 0; i--){
                if(o1[i] != o2[i]){
                    return o2[i]-o1[i];
                }
            }
            return 0;
        });

        return list.get(0);
    }

    public static void DFS(int n, int depth, int start){
        if(depth == n){
            int lionSum = 0; //라이언 총 점수
            int peachSum = 0; //어피치 총 점수
            for(int i = 0; i<10; i++){
                if(peachInfo[i] == 0 && lionInfo[i] == 0){
                    continue;
                }
                if(peachInfo[i] >= lionInfo[i]){
                    peachSum += 10-i;
                } else {
                    lionSum += 10-i;
                }
            }
            if(lionSum > peachSum){
                int diff = lionSum - peachSum;
                if(max_diff < diff){
                    max_diff = diff;
                    list.clear();
                    list.add(lionInfo.clone());
                } else if(max_diff == diff){
                    list.add(lionInfo.clone());
                }
            }
            return;
        }

        for(int i = start; i<11; i++){
            lionInfo[i]++;
            DFS(n,depth+1, i);
            lionInfo[i]--;
        }
    }
}
//1. 10점부터 이길 수 있는 방안으로 생각하기

// 규칙
// 1. 어피치가 먼저 화살 n발 -> 라이언 화살 n발
// 2. 점수계산
// k점에 어피치가 a발, 라이언 b발일 때 a , b 중 더 큰 값을 갖는 선수가 k점을 갖게된다.
// 단, a==b여도 어피치가 가져간다.
// k발을 여러번 맞춰도 k점보다 많은수를 가져가는 것이 아니다.
// 3. 최종점수가 같으면 어피치가 우승자

// => 라이언이 화살 n발을 어떤 과녁에 맞춰야 이길 수 있는ㄱ?

// info : 어피치가 맞힌 과녁 점수의 개수 [10점, 9점 ,````1점, 0점] 순으로!
// return : 라이언이 n발의 화살을 어떤 과녁 점수에 맞혀야하는지
// 만약 우승 가능성이 없다면 -1
// 만약 우승방법이 여러가지라면, 가장 낮은 점수를 더 많이 맞힌 경우를 return