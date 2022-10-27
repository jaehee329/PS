import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a17614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int clap = 0;
        for (int i=1; i<=N; i++) {
            String s = Integer.toString(i);
            for (int j=0; j<s.length(); j++) {
                char c = s.charAt(j);
                if (c=='3' || c=='6' || c=='9') {
                    clap++;
                }
            }
        }
        System.out.println(clap);
    }    
}
