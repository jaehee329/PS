import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a2011 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        int len = temp.length();
        if(temp.charAt(0)=='0'){
            System.out.println("0");
            return;
        }
        long[] dp = new long[len+1]; dp[0] = dp[1] = 1;
		for(int i=2;i<=len;i++) {
            char curr = temp.charAt(i-1);
            char prev = temp.charAt(i-2);
            if(curr=='0'){
                if(prev =='1' || prev =='2'){
                    dp[i] = dp[i-2];
                } else { break; }
            } else {
                if(prev == '0'){
                    dp[i] = dp[i-1];
                } else {
                    int t = (prev-'0')*10+(curr-'0');
                    if(1<=t && t<=26) dp[i]=(dp[i-2]+dp[i-1])%1000000;
					else dp[i]=dp[i-1]%1000000;
                }
            }
		}
		System.out.println(dp[len]%1000000);


        
    }
}