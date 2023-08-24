import java.io.*;
import java.util.*;

public class a1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int[][] arr = new int[height][width];
        int[][] dp = new int[height][width];
        int max = 0;

        for(int i = 0 ; i < height; i++) {
            String line = br.readLine();
            for(int j = 0 ; j < width; j++) {
                arr[i][j] = line.charAt(j) - '0';
                dp[i][j] = arr[i][j];
                if(i >= 1 && j >= 1) {
                    if(dp[i - 1][j] > 0 && dp[i - 1][j - 1] > 0 && dp[i][j - 1] > 0 && dp[i][j] > 0) {
                        int min = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                        dp[i][j] = min + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max * max);
    }
}