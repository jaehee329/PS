import java.io.*;
import java.util.*;

public class a2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        boolean discard = true;
        while (queue.size() > 1) {
            if (discard) {
                queue.poll();
            } else {
                int head = queue.poll();
                queue.add(head);
            }
            discard = !discard;
        }

        System.out.println(queue.poll());
    }
}
