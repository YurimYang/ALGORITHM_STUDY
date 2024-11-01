import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String[] line = br.readLine().split(" ");
            int sum = 0;
            for(int i = 0; i<line.length; i++){
                if(Integer.parseInt(line[i]) % 2 !=0){
                    sum += Integer.parseInt(line[i]);
                }
            }
            System.out.println("#"+test_case + " " + sum);

		}
	}
}