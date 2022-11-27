// calculating BigInteger
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class a2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger x = new BigInteger("1");
        for (int i = n; i >= n-m+1; i--) {
            x = x.multiply(new BigInteger(Integer.toString(i)));
        }
        for (int i = m; i >= 1; i--) {
            x = x.divide(new BigInteger(Integer.toString(i)));
        }
        System.out.println(x);
    }
}
