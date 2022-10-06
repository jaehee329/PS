import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a2193 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] ans = new long[N+1][2];
        ans[1][0] = 0; ans[1][1] = 1;
        if(N>1){
            for(int i=2; i<=N; i++){
                ans[i][0]=ans[i-1][1] + ans[i-1][0];
                ans[i][1]=ans[i-1][0];
            }
            System.out.println(ans[N][0]+ans[N][1]);
        } else {
            System.out.println(1);
        }
    }
}