import java.util.*;
import java.io.*;

public class Main {

    static PriorityQueue<Person> pq = new PriorityQueue<>((o1,o2) -> {
        if(o1.cnt != o2.cnt){
            return o1.cnt - o2.cnt;
        } else {
            return o2.time - o1.time;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int times = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<times; i++){
            int person = Integer.parseInt(st.nextToken());
            if(!cntPlus(person)) {
                if(pq.size() == n){
                    pq.poll();  
                } 
                pq.offer(new Person(person, 1, 0));
            }
            timePlus();
        }

        List<Person> list = new ArrayList<>(pq);

        Collections.sort(list, (o1, o2) -> o1.num - o2.num);

        for(Person p : list){
            System.out.print(p.num + " ");
        }
    }

    public static boolean cntPlus(int num){
        boolean isCntChanged = false;
        List<Person> tmpList = new ArrayList<>(pq);
        pq.clear();
        for(Person person : tmpList){
            if(person.num == num){
                person.cnt +=1;
                isCntChanged = true;
            }
            pq.offer(person);
        }
        return isCntChanged;
    }

    public static void timePlus(){
        List<Person> tmpList = new ArrayList<>(pq);
        pq.clear();
        for(Person person : tmpList){
            person.time += 1;
            pq.offer(person);
        }
    }
}

class Person  {
    int num;
    int cnt;
    int time;

    public Person(int num, int cnt, int time){
        this.num = num;
        this.cnt = cnt;
        this.time = time;
    }
}