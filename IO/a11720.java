import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a11720{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int sum = 0;
        for(int i=0; i<N; i++){
            sum+=str.charAt(i)-48;
        }
        System.out.println(sum);
    }
}
