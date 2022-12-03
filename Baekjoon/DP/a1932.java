import java.io.*;
import java.util.*;

public class a1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
            dp[i][i] = triangle[i][i] + dp[i-1][i-1];
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = dp[N-1][i] > max ? dp[N-1][i] : max;
        }
        System.out.println(max);
    }
}
