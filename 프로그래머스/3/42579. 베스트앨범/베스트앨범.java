import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, List<PlaysNum>> hm = new HashMap<>();
        HashMap<String, Integer> countMaxPlays = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            if (!hm.containsKey(genres[i])) {
                hm.put(genres[i], new ArrayList<>());
            }
            hm.get(genres[i]).add(new PlaysNum(i, plays[i]));
            countMaxPlays.put(genres[i], countMaxPlays.getOrDefault(genres[i], 0) + plays[i]);
        }

        // Sorting genres by total plays in descending order
        List<String> keySet = new ArrayList<>(countMaxPlays.keySet());
        keySet.sort((o1, o2) -> countMaxPlays.get(o2).compareTo(countMaxPlays.get(o1)));

        List<Integer> result = new ArrayList<>();
        for (String genre : keySet) {
            List<PlaysNum> playsNumList = hm.get(genre);
            // Sort songs in the genre by plays in descending order
            Collections.sort(playsNumList);
            // Add up to 2 songs from this genre
            for (int i = 0; i < Math.min(2, playsNumList.size()); i++) {
                result.add(playsNumList.get(i).idx);
            }
        }

        // Converting result list to array
        return result.stream().mapToInt(i -> i).toArray();
    }

    class PlaysNum implements Comparable<PlaysNum> {
        int idx;
        int plays;

        public PlaysNum(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }

        @Override
        public int compareTo(PlaysNum o) {
            return o.plays - this.plays;
        }
    }
}
