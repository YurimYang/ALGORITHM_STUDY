class Solution {
    public static int[] discount = {10, 20, 30, 40};
    public static int maxOfSubscribe;
    public static int maxOfCost;

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        int[] discounts = new int[emoticons.length];

        DFS(0, discounts,users, emoticons);
        return new int[] {maxOfSubscribe,maxOfCost};
    }

    public static void DFS(int idx, int[] discounts, int[][] users,  int[] emoticons) {
        if (idx == emoticons.length) {
            int subscribe = 0;
            int cost = 0;

            for (int[] user : users) {
                int userDiscountRate = user[0];
                int userMaxCost = user[1];

                int sum = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (discounts[i] >= userDiscountRate) {
                        sum += emoticons[i]/100 * (100 - discounts[i]);
                    }
                }
                if (sum >= userMaxCost) {
                    subscribe++;
                } else {
                    cost += sum;
                }
            }

            if(subscribe > maxOfSubscribe){
                maxOfSubscribe = subscribe;
                maxOfCost = cost;
            } else if (subscribe == maxOfSubscribe){
                maxOfCost = Math.max(maxOfCost,cost);
            }
            return;
        }

        for(int i = 0; i<4; i++){
            discounts[idx] = discount[i];
            DFS(idx+1, discounts,users,emoticons);
        }

    }
}