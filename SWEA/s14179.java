import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s14179 {
    private static int T;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i=1; i<=T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int range = 2*D+1;
            int answer = N/range;
            if (!(N%range==0)) {
                answer++;
            }
            sb.append("#" + i + " " + answer + "\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
