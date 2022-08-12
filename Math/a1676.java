import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a1676 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
		int c = 0; 
		while(N>=5) {
			c += N/5;
			N/=5;
		}
		System.out.println(c);
    }
}