import java.io.*;
import java.util.*;

public class a22993 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int otherPlayers = Integer.parseInt(br.readLine()) - 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        Long junwonPower = Long.parseLong(st.nextToken());

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < otherPlayers; i++) {
            priorityQueue.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < otherPlayers; i++) {
            Long weakestPower = priorityQueue.poll();
            if (junwonPower <= weakestPower) {
                System.out.println("No");
                return;
            } else {
                junwonPower += weakestPower;
            }
        }
        System.out.println("Yes");
    }
}
