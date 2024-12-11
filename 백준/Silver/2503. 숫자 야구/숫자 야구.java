import java.util.*;
import java.io.*;

public class Main {

    static List<Game> games = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String preAns = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            games.add(new Game(preAns, strike, ball));
        }

        createNumber("", 0, new int[10]);
        System.out.println(answer);

    }

    public static void createNumber(String number, int size, int[] usedNum){
        if(size == 3){
            isSatisfiedNumber(number);
            return;
        }

        for(int i = 1; i<10; i++){
            if(usedNum[i] == 0){
                usedNum[i] = 1;
                createNumber(number + i, size+1, usedNum);
                usedNum[i] = 0;
            }
        }

    }

    public static void isSatisfiedNumber(String number){
        for(Game game : games){
            //스트라이크 조건 만족
            int strike = 0;
            for(int i = 0; i<3; i++){
                if(game.number.charAt(i) == number.charAt(i)){
                    strike++;
                }
            }

            if(game.strike != strike){
                return;
            }
            //볼 조건 만족
            int ball = 0;
            for(int i = 0; i<3; i++){
                if(game.number.contains(String.valueOf(number.charAt(i))) && game.number.charAt(i) != number.charAt(i)){
                    ball++;
                }
            }

            if(ball != game.ball){
                return;
            }
        }
        answer++;
    }
}

class Game{
    String number;
    int strike;
    int ball;

    public Game(String number, int strike, int ball) {
        this.number = number;
        this.strike = strike;
        this.ball = ball;
    }
}