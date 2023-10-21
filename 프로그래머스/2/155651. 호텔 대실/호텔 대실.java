import java.util.*;
class Solution {
public static int solution(String[][] book_time) {
        int answer = 0;
        List<BookTime> bookTimeList = HourToMin(book_time);
        Queue<Integer> bookCompleteQueue = new PriorityQueue<>();

        for(int i = 0; i<bookTimeList.size();i++){
            BookTime curBookTime = bookTimeList.get(i);
            if(bookCompleteQueue.isEmpty()){
                bookCompleteQueue.add(curBookTime.endTime);
                continue;
            }
            int earEmptyTime = bookCompleteQueue.peek();
            if(curBookTime.startTime >= earEmptyTime){
                bookCompleteQueue.poll();
                bookCompleteQueue.add(curBookTime.endTime);
            }else{
                bookCompleteQueue.add(curBookTime.endTime);
            }

        }
        return bookCompleteQueue.size();

    }

    public static List<BookTime> HourToMin(String[][] book_time){
        List<BookTime> bookTimeList = new ArrayList<>();
        for(int i = 0; i<book_time.length; i++){
                String[] startTime = book_time[i][0].split(":");
                int startHour = Integer.parseInt(startTime[0]);
                int startMin = Integer.parseInt(startTime[1]);
                int startTotalTime = (startHour * 60) + startMin;

                String[] endTime = book_time[i][1].split(":");
                int endHour = Integer.parseInt(endTime[0]);
                int endMin = Integer.parseInt(endTime[1]) + 10;
                int endTotalTime = (endHour * 60) + endMin;

                BookTime bookTime = new BookTime(startTotalTime,endTotalTime);
                bookTimeList.add(bookTime);
        }
        bookTimeList.sort((o1,o2) -> o1.startTime - o2.startTime);

        return bookTimeList;

    }

    static class BookTime{
        int startTime, endTime;

        public BookTime(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}