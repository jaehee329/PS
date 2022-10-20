import java.io.*;

public class s14692 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=1; i<=N; i++) {
            int t = Integer.parseInt(br.readLine());
            String s = (t%2 == 0) ? "Alice" : "Bob";
            System.out.println("#" + i + " " + s);
        }
    }
}
