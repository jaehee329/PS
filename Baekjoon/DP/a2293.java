import java.io.*;
import java.util.*;

public class a2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int types = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        int[] values = new int[types];

        values = new int[types + 1];
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for(int i = 1; i <= types; i++) {
            values[i] = Integer.parseInt(br.readLine());
            for (int j = values[i]; j <= sum; j++) {
                dp[j] += dp[j - values[i]];
            }
        }
        System.out.println(dp[sum]);
    }
}
