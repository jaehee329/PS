import java.io.*;
import java.util.StringJoiner;

public class a12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // dp[i][0] = i를 1로 만드는 연산의 최소, dp[i][1] = i를 1로 만드는 최소 연산 중 한 번의 연산을 한 값
        int[][] dp = new int[Math.max(6, n + 1)][2];
        dp[2][0] = 1; dp[2][1] = 1;
        dp[3][0] = 1; dp[3][1] = 1;
        dp[4][0] = 2; dp[4][1] = 2;
        dp[5][0] = 3; dp[5][1] = 4;
        for (int i = 6; i <= n; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                if (dp[i / 3][0] <= dp[i / 2][0] && dp[i / 3][0] <= dp[i - 1][0]) {
                    dp[i][0] = dp[i / 3][0] + 1;
                    dp[i][1] = i / 3;
                } else if (dp[i / 2][0] <= dp[i / 3][0] && dp[i / 2][0] <= dp[i - 1][0]) {
                    dp[i][0] = dp[i / 2][0] + 1;
                    dp[i][1] = i / 2;
                } else {
                    dp[i][0] = dp[i - 1][0] + 1;
                    dp[i][1] = i - 1;
                }
            } else if (i % 3 == 0) {
                if (dp[i / 3][0] <= dp[i - 1][0]) {
                    dp[i][0] = dp[i / 3][0] + 1;
                    dp[i][1] = i / 3;
                } else {
                    dp[i][0] = dp[i - 1][0] + 1;
                    dp[i][1] = i - 1;
                }
            } else if (i % 2 == 0) {
                if (dp[i / 2][0] <= dp[i - 1][0]) {
                    dp[i][0] = dp[i / 2][0] + 1;
                    dp[i][1] = i / 2;
                } else {
                    dp[i][0] = dp[i - 1][0] + 1;
                    dp[i][1] = i - 1;
                }
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = i - 1;
            }
        }
        System.out.println(dp[n][0]);
        StringJoiner sj = new StringJoiner(" ");
        int current = n;
        while (current != 1) {
            sj.add(Integer.toString(current));
            current = dp[current][1];
        }
        sj.add("1");
        System.out.println(sj.toString());
    }
}
