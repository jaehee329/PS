import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a9461 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cse = new int[N];
        int max = 6;
        for(int i=0; i<N; i++){
            cse[i] = Integer.parseInt(br.readLine());
            max = max<cse[i] ? cse[i] : max;
        }
        long[] dp = new long[max+1]; dp[0] = 0; dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2; dp[5] = 2;
        for(int i=6; i<=max; i++){
            dp[i]=dp[i-5]+dp[i-1];
        }
        for(int i:cse){
            System.out.println(dp[i]);
        }

    }
}