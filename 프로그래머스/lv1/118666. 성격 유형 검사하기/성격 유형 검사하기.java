import java.util.HashMap;
import java.util.Map;
class Solution {
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        char[] basicSurvey = {'R','T','C','F','J','M','A','N'};
        Map<Character, Integer> finalCountMap = new HashMap<>(); //최종점수 Map

        //기본 세팅
        for(int i = 0;i<basicSurvey.length;i++){
            finalCountMap.put(basicSurvey[i],0);
        }

        for (int i = 0; i < survey.length; i++) {
            char[] characters = survey[i].toCharArray();
            char target = 0;
            if (choices[i] > 4) {
                target = characters[1];
                finalCountMap.put(target, finalCountMap.getOrDefault(target, 0) + choices[i] - 4);
            } else if (choices[i] < 4) {
                target = characters[0];
                int score = checkingNumber(choices[i]);
                finalCountMap.put(target, finalCountMap.getOrDefault(target, 0) + score);
            }
        }
        int j = 0;
        while(j<8){
            int first = finalCountMap.get(basicSurvey[j]);
            int second = finalCountMap.get(basicSurvey[j+1]);
            if(first >= second){
                answer+=basicSurvey[j];
            }else if(first<second) {
                answer += basicSurvey[j + 1];
            }
            j+=2;
        }
        return answer;
    }

    public static int checkingNumber(int num) {
        if (num == 1) {
            return 3;
        } else if (num == 2) {
            return 2;
        } else {
            return 1;
        }
    }
}