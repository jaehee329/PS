import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a12865 {
    private static int[][] dp;
    private static int N;
    private static int K;
    private static int[][] WVArr;
    public static void main(String[] args) throws Exception {
        staticVarSetter();
        setDpArr();
        System.out.println(dp[N][K]);
    }
    private static void staticVarSetter() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        WVArr = new int[N+1][2];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            WVArr[i][0] = Integer.parseInt(st.nextToken());
            WVArr[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1][K+1];
    }
    private static void setDpArr() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                int weight = WVArr[i][0];
                if(weight<=j) {
                    dp[i][j] = Math.max(dp[i-1][j], WVArr[i][1] + dp[i-1][j-weight]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }
}
