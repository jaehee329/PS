import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a11057 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] ans = new long[N+1][10];
        for(int i=0; i<10; i++){
            ans[1][i]=1;
        }
        for(int i=2; i<=N; i++){
            for(int j=0; j<10;j++){
                for(int k=0; k<=j;k++){
                    ans[i][j]+=ans[i-1][k]%10_007;
                }
            }
        }
        long sum =0;
        for(int i=0; i<10; i++){
            sum += ans[N][i];
        }
        System.out.println(sum%10_007);
    }
}