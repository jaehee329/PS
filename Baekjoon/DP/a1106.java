import java.io.*;
import java.util.*;

public class a1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int cityCount = Integer.parseInt(st.nextToken());
        
        int[][] incrementAndCost = new int[cityCount][2];
        for (int i = 0; i < cityCount; i++) {
            st = new StringTokenizer(br.readLine());
            incrementAndCost[i][1] = Integer.parseInt(st.nextToken());
            incrementAndCost[i][0] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(incrementAndCost, (incAndCost1, incAndCost2) -> incAndCost1[0] - incAndCost2[0]);

        int mostIncreasing = incrementAndCost[cityCount - 1][0];
        int dpLimit = total + mostIncreasing;
        int[][] dp = new int[cityCount + 1][dpLimit];
        for (int i = 0; i < dpLimit; i++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < cityCount; j++) {
                int increment = incrementAndCost[j][0];
                int cost = incrementAndCost[j][1];
                if (i < increment) {
                    dp[j][i] = Integer.MAX_VALUE;
                    continue;
                }
                if (dp[cityCount][i - increment] == Integer.MAX_VALUE) {
                    if (i % increment == 0) {
                        dp[j][i] = cost;
                    } else {
                        dp[j][i] = Integer.MAX_VALUE;
                    }
                } else {
                    dp[j][i] = dp[cityCount][i - increment] + cost;
                }
                minCost = Math.min(dp[j][i], minCost);
            }
            dp[cityCount][i] = minCost;
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = total; i < dpLimit; i++) {
            minCost = Math.min(minCost, dp[cityCount][i]);
        }
        System.out.println(minCost);
    }
}
