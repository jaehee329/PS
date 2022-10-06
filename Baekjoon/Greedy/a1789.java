import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        int n = (int)(Math.sqrt(2*s+0.25)-0.5);
        System.out.println(n);
    }
}
