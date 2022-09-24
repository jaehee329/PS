import java.io.*;
import java.util.*;

public class a15724 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][M + 1];
        for (int x = 1; x <= N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 1; y <= M; y++) {
                int t = Integer.parseInt(st.nextToken());
                dp[x][y] = dp[x-1][y] + dp[x][y-1] + t - dp[x-1][y-1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
