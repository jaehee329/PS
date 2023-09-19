import java.io.*;
import java.util.*;

public class a26215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(n, Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        int t = 0;
        while (t <= 1440 && !q.isEmpty()) {
            int biggest = q.poll();
            if (!q.isEmpty()) {
                int next = q.poll();
                if (next > 1) {
                    q.add(--next);
                }
            }
            if (biggest > 1) {
                q.add(--biggest);
            }
            t++;
        }
        if (t == 1441) {
            System.out.println(-1);
            return;
        }
        System.out.println(t);
    }
}
