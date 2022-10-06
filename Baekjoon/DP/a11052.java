import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class a11052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int [N+1]; P[0] = 0;
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        for(int i=1; i<=N; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N+1][N+1]; dp[1][1] = P[1];
        for(int i=1; i<=N; i++){
            dp[i][1] = P[1]*i;
            for(int j=2; j<=N; j++){
                if(i<j){
                    dp[i][j] = dp[i][i];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-j][j]+P[j]);
                }
            }
        }
        System.out.println(dp[N][N]);
    }
}