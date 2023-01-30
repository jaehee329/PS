// BFS, use Long for *10 operation, long for comparison
import java.io.*;
import java.util.*;

public class a16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        Queue<Long[]> q = new LinkedList<>();
        q.add(new Long[]{A, 1L});
        while (!q.isEmpty()) {
            Long[] t = q.poll();
            long val = t[0];
            Long iter = t[1];
            if (val == B) {
                System.out.println(iter);
                return;
            }

            Long next = val * 2;
            if (next <= B) {
                q.add(new Long[]{next, iter+1});
            }
            next = val * 10 + 1;
            if (next <= B) {
                q.add(new Long[]{next, iter+1});
            }
        }
        System.out.println(-1);
    }
}
