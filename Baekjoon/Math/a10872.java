import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a10872 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = 1;
        for(int i=1; i<=N; i++) a*=i;
        System.out.println(a);
    }
}