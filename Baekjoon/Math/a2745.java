import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class a2745 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int ans = 0;
        int length = N.length();
        for(int i=1; i<=length; i++){
            if(N.charAt(length-i)<'0'+10){
                ans+=Math.pow(B,i-1) * (int)(N.charAt(length-i)-'0');
            } else {
                ans+=Math.pow(B,i-1) * (int)(N.charAt(length-i)-'A'+10);
            }
        }
        System.out.println(ans);
    }
}