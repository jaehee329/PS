import java.io.*;
import java.util.*;

public class a2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int connectionCount = Integer.parseInt(br.readLine());

        int[][] connections = new int[connectionCount][2];

        StringTokenizer st;
        for (int i = 0; i < connectionCount; i++) {
            st = new StringTokenizer(br.readLine());
            int aPos = Integer.parseInt(st.nextToken());
            int bPos = Integer.parseInt(st.nextToken());
            connections[i][0] = aPos;
            connections[i][1] = bPos;
        }

        Arrays.sort(connections, (a, b) -> a[0] - b[0]);

        int[] dp = new int[connectionCount];
        int max = 0;
        for (int i = 0; i < connectionCount; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (connections[j][1] < connections[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        System.out.println(connectionCount - max);
    }
}
