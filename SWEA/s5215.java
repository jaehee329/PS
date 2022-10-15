// 0-1 knapsack, DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s5215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=1; i<=tc; i++) {
            addBestCombination(i, br, sb);
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    private static void addBestCombination(int idx, BufferedReader br, StringBuilder sb) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int maxCal = Integer.parseInt(st.nextToken());
        int[][] scoreCal = new int[N+1][2];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            scoreCal[i][0] = Integer.parseInt(st.nextToken());
            scoreCal[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N+1][maxCal+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=maxCal; j++) {
                if(scoreCal[i][1]>j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(scoreCal[i][0] + dp[i-1][j-scoreCal[i][1]], dp[i-1][j]);
                }
            }
        }
        int bestScore = dp[N][maxCal];
        sb.append("#" + idx + " " + bestScore + "\n");
    }
}