import java.util.*;
class Solution {
    public static List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> taskMap = new HashMap<>(); //과제 순서 저장 맵
        Queue<Plans> plansQueue = new PriorityQueue<>((o1, o2) -> (o1.start - o2.start)); //시작순서대로 오름차순으로 변경하기
        Stack<Plans> leftPlansStk = new Stack(); //잠시 멈춘 과제

        //각 과목별 시작시간 plansList에 저장하기
        for(int i = 0; i<plans.length; i++){
            String[] time = plans[i][1].split(":");
            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);
            int totalTime = (hour * 60) + min;
            plansQueue.offer(new Plans(plans[i][0], totalTime, Integer.parseInt(plans[i][2])));
        }



        //과제 시작해서 stk에 넣어두는 logic
        while(!plansQueue.isEmpty()) {
            Plans now = plansQueue.poll(); //비교대상 1
            Plans next = plansQueue.peek(); //비교대상 2
            int presentTime = now.start; //현재 시각

            if (!plansQueue.isEmpty()) {
                //현재과제를 새로운과제 시작 전까지 못 끝내는 경우
                if (now.start + now.playtime > next.start) {
                    now.playtime = now.playtime - (next.start - presentTime);
                    leftPlansStk.push(new Plans(now.name, now.start, now.playtime));

                //현재 과제를 끝나면 새로운 과제 시작일 경우
                } else if (now.start + now.playtime == next.start) {
                    answer.add(now.name);
                    continue;

                //현재 과제를 새로운 과제 시작 전까지 끝내는 경우
                } else {
                    answer.add(now.name);
                    presentTime += now.playtime;

                    //stack에 과제가 있는 경우 남는 시간동안 멈췄던 과제 해결
                    while (!leftPlansStk.isEmpty()) {
                        Plans leftNow = leftPlansStk.pop();

                        //left과제를 새로운 과제 시작 전까지 못 끝내는 경우
                        if (presentTime + leftNow.playtime > next.start) {
                            leftNow.playtime = leftNow.playtime - (next.start - presentTime);
                            leftPlansStk.push(new Plans(leftNow.name, leftNow.start,
                                leftNow.playtime));
                            break;

                            //left 과제를 새로운 과제 시작 전까지 끝낼 수 있는 경우
                        } else {
                            presentTime += leftNow.playtime;
                            answer.add(leftNow.name);
                            continue;
                        }
                    }

                }
            } else {
                if(leftPlansStk.isEmpty()){
                    presentTime += now.playtime;
                    answer.add(now.name);
                } else {
                    answer.add(now.name);
                    while(!leftPlansStk.isEmpty()){
                        Plans leftNow = leftPlansStk.pop();
                        answer.add(leftNow.name);
                    }
                }
            }
        }

        return answer;
    }

    static class Plans{
        String name;
        int start;
        int playtime;

        public Plans(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
}