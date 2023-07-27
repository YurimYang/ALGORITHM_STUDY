import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
            //해당 key값에 저장된 value가 null이면 1을 대입 아니면 +1을 해준다.
			if(hash.get(input) == null) hash.put(input, 1);
			else hash.put(input, hash.get(input) + 1);
		}
		
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int input = Integer.parseInt(st.nextToken());
            //해당 key값에 저장된 value가 null이면 0을 sb에 저장해준다.
			if(hash.get(input) == null) sb.append(0).append(" ");
			else sb.append(hash.get(input)).append(" ");
		}
		System.out.println(sb);
	}

}