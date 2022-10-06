import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class a2004 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken()); long m = Long.parseLong(st.nextToken());
		long c5 = f5(n)-f5(n-m)-f5(m); long c2 = f2(n)-f2(n-m)-f2(m);
		System.out.println(Math.min(c5, c2));
    }
	static long f5(long n){
		long c=0;
		while(n>=5) {
			c+=n/5; n/=5;
		}
		return c;
	}
	static long f2(long n){
		long c=0;
		while(n>=2) {
			c+=n/2; n/=2;
		}
		return c;
	}
}