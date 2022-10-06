import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a2133 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N%2==1){
            System.out.println(0);
        }else{
            int[] dp = new int[N+1];
            dp[2]=3;
            for(int i=4; i<=N; i=i+2){
                int temp = 0;
                for(int j=i-2; j>=2; j=j-2){
                    temp += 2*dp[j];
                }
                dp[i] = temp + dp[i-2] + 2;
            }
            System.out.println(dp[N]);
        }
    }
}
// f(2) = 3
// f(4) = f(2)*3 + 2 = 11
// f(6) = f(4)*3 + f(2)*2 + 2 = 41
// f(8) = f(6)*3 + f(4)*2 + f(2)*2 + 2