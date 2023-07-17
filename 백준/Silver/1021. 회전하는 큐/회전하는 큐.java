import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
/**
 * 백준 전체 1021 문제 알고리즘 클래스
 *
 * @author RWB
 * @see <a href="https://blog.itcode.dev/posts/2021/07/14/A1021/">1021 풀이</a>
 * @since 2021.07.14 12:57:01
 */
public class Main
{
    // 뽑을 수의 갯수
    private static int M;
    
    // 큐
    private static final LinkedList<Integer> QUEUE = new LinkedList<>();
    
    /**
     * 메인 함수
     *
     * @param args: [String[]] 매개변수
     *
     * @throws IOException 데이터 입출력 예외
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // N과 M
        int[] meta = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // 수의 위치
        int[] position = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // 큐의 크기
        int N = meta[0];
        
        M = meta[1];
        
        // 큐의 크기만큼 큐 초기화
        for (int i = 0; i < N; i++)
        {
            QUEUE.add(i + 1);
        }
        
        writer.write(String.valueOf(solve(position)));
        writer.newLine();
        
        writer.close();
        reader.close();
    }
    
    /**
     * 큐 연산 갯수 반환 함수
     *
     * @param position: [int[]] 수의 위치 배열
     *
     * @return [int] 연산 갯수
     */
    private static int solve(int[] position)
    {
        int count = 0;
        
        for (int i = 0; i < M; i++)
        {
            // 뽑을 요소의 인덱스
            int target = QUEUE.indexOf(position[i]);
            
            // 구간 구분 기준
            int ref = QUEUE.size() / 2;
            
            // 오른쪽으로 이동하는 게 더 빠를 경우
            if (target > ref)
            {
                while (position[i] != QUEUE.getFirst())
                {
                    // 맨 끝 요소를 제거하고 맨 앞에 추가
                    QUEUE.addFirst(QUEUE.removeLast());
                    count++;
                }
            }
            
            // 왼쪽으로 이동하는 게 더 빠를 경우
            else
            {
                while (position[i] != QUEUE.getFirst())
                {
                    // 맨 앞 요소를 제거하거 맨 끝에 추가
                    QUEUE.addLast(QUEUE.removeFirst());
                    count++;
                }
            }
            
            QUEUE.removeFirst();
        }
        
        return count;
    }
}
