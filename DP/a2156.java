import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a2156 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1]; int[] data = new int[N+1];
        dp[0] = 0; data[0] = 0;
        for(int i=1; i<=N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = data[1];
        if(N>1){
            dp[2] = data[1]+data[2];
        }
        for(int i=3; i<=N; i++){
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+data[i], dp[i-3]+data[i-1]+data[i]));
        }
        System.out.println(dp[N]);
    }
}