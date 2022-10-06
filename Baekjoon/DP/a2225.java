import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class a2225 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N][K];
        for(int i=0; i<K; i++){
            for(int j=0; j<N; j++){
                if(i==0){
                    dp[j][i] = 1;
                } else {
                    long sum=0;
                    for(int k=0; k<=j; k++){
                        sum += dp[k][i-1] % 1_000_000_000;
                    }
                    dp[j][i] = (sum+1) % 1_000_000_000;
                }
            }
        }
        System.out.println(dp[N-1][K-1]);
    }
}