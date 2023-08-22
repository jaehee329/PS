import java.io.*;
import java.util.*;

public class a2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int types = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        int[] values = new int[types + 1];
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, 100_001);
        dp[0] = 0;
        
        for(int i = 1; i <= types; i++) {
            values[i] = Integer.parseInt(br.readLine());
            for (int j = values[i]; j <= sum; j++) {
                dp[j] = Math.min(dp[j], dp[j - values[i]] + 1);
            }
        }
        
        if (dp[sum] == 100_001) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[sum]);
    }
}
