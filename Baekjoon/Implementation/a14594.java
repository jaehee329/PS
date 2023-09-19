import java.io.*;
import java.util.StringTokenizer;

public class a14594 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] wall = new boolean[n + 1];

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            for (int j = from; j < to; j++) {
                wall[j] = true;
            }
        }

        int room = 0;
        for (int i = 1; i <= n; i++) {
            if (!wall[i]) {
                room++;
            }
        }
        System.out.println(room);
    }
}