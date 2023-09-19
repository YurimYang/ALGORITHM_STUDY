import java.util.HashMap;
class Solution {
        public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> hm = new HashMap<>();
        int cnt = 1;
        for(String player : players){
            hm.put(player,cnt);
            cnt++;
        }

        for(String calling : callings){
            int num = hm.get(calling); //kai - 4(num)
            hm.put(calling,num-1); // kai - 3
            if(num>1){
                String changes = players[num-2]; // poe
                players[num-1] = changes;
                players[num-2] = calling;
                hm.put(changes,num); // poe - 4
            }
        }


        for(int values : hm.values()){
            if (values > 0) {
                answer[values-1] = players[values-1];
            }
        }
        
        return answer;
    }
}