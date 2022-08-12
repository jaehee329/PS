import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class a1699 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1]; dp[0]=0; dp[1]=1;
        if(N>1){
            for(int i=1; i<=N; i++){
                int limit = (int)Math.sqrt(i);
                int min = 100_000;
                for(int j=1; j<=limit; j++){
                    min = min > dp[i-j*j] ? dp[i-j*j] : min;
                }
                dp[i]=min+1;
            }
        }
        System.out.println(dp[N]);
    }
}