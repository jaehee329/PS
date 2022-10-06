import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class a11054 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        int[] dp = new int[N];
        int[] dp2 = new int[N];
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(data[i] > data[j] && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        for(int i=N-1; i>=0; i--){
            dp2[i]=1;
            for(int j=N-1; j>i; j--){
                if(data[i] > data[j] && dp2[i]<dp2[j]+1){
                    dp2[i] = dp2[j]+1;
                }
            }
        }
        for(int i=0; i<N; i++){
            ans[i] = dp[i]+dp2[i]-1;
        }        
        int max = -1;
        for(int i=0; i<N; i++){
            max = max > ans[i] ? max:ans[i];
        }
        System.out.println(max);
    }
}