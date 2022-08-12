import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class a1912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] data = new Integer[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = data[0];
        for(int i=1; i<N; i++){
            if(data[i-1]>=0){
                dp[i] = dp[i-1] + data[i];
            } else {
                dp[i] = Math.max(dp[i-1]+data[i],data[i]);
            }
        }

        int max = dp[0];
        for(int i=0; i<N; i++){
            max = max > dp[i] ? max:dp[i];
        }
        System.out.println(max);
    }
}