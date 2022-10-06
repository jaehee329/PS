import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class a11055 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            dp[i]=data[i];
            for(int j=0; j<i; j++){
                if(data[i] > data[j] && dp[i]<dp[j]+data[i]){
                    dp[i] = dp[j]+data[i];
                }
            }
        }
        int max = -1;
        for(int i=0; i<N; i++){
            max = max > dp[i] ? max:dp[i];
        }
        System.out.println(max);
    }
}