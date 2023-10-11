import java.io.*;

public class a15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        int[] nums = new int[tc];
        for (int i = 0; i < tc; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        
        int[][] dp = new int[10_001][4];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		for(int i = 4; i <= 10_000; i++) {
			dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1] + dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}

        for (int i = 0; i < tc; i++) {
            bw.write(dp[nums[i]][1] + dp[nums[i]][2] + dp[nums[i]][3] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
