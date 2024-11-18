import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int h, w, size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Size> list = new ArrayList<Size>();

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        size = h * w;

        int answer = 0;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (r * c <= size) {
                list.add(new Size(r, c, r * c));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Size s1 = list.get(i);
                Size s2 = list.get(j);

                int tmpSize = s1.size + s2.size;

                //수평, 수평, 가로
                if(s1.r + s2.r <= h && Math.max(s1.c, s2.c) <= w){
                    answer = Math.max(answer, tmpSize);
                }
                //수평, 수평, 세로
                if(Math.max(s1.r, s2.r) <= h && s1.c + s2.c <= w){
                    answer = Math.max(answer, tmpSize);
                }

                //수직, 수평, 가로
                if(s1.c + s2.r <= h && Math.max(s1.r, s2.c) <= w){
                    answer = Math.max(answer, tmpSize);
                }
                //수직, 수평, 세로
                if(Math.max(s1.c, s2.r) <= h && s1.r + s2.c <= w){
                    answer = Math.max(answer, tmpSize);
                }

                //수평, 수직, 가로
                if(s1.r + s2.c <= h && Math.max(s1.c, s2.r) <= w){
                    answer = Math.max(answer, tmpSize);
                }
                //수평, 수직, 세로
                if(Math.max(s1.r, s2.c) <= h && s1.c + s2.r <= w){
                    answer = Math.max(answer, tmpSize);
                }

                //수직, 수직, 가로
                if(s1.c + s2.c <= h && Math.max(s1.r, s2.r) <= w){
                    answer = Math.max(answer, tmpSize);
                }
                //수직, 수직, 세로
                if(Math.max(s1.c, s2.c) <= h && s1.r + s2.r <= w){
                    answer = Math.max(answer, tmpSize);
                }

            }
        }

        System.out.println(answer);


    }
}

class Size {
    int r;
    int c;
    int size;

    public Size(int r, int c, int size) {
        this.r = r;
        this.c = c;
        this.size = size;
    }
}
