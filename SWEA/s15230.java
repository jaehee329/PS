import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s15230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String ideal = "abcdefghijklmnopqrstuvwxyz";
        for (int i=1; i<=tc; i++) {
            String target = br.readLine();
            int len = target.length();
            for (int j=0; j<len; j++) {
                if (ideal.charAt(j) != target.charAt(j)) {
                    sb.append("#" + i + " " + j + "\n");
                    break;
                } else if (j==len-1) {
                    sb.append("#" + i + " " + len + "\n");
                }
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
