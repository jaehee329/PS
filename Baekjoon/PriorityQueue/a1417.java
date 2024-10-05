import java.io.*;
import java.util.*;

public class a1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N - 1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int toBribe = 0;
        while (!pq.isEmpty()) {
            int biggest = pq.poll();
            if (biggest < dasom) {
                break;
            } else {
                toBribe++;
                dasom++;
                pq.add(biggest - 1);
            }
        }
        System.out.println(toBribe);
    }
}
