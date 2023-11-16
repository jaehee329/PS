import java.io.*;
import java.util.*;

public class a2961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] tastes = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            tastes[i][0] = Integer.parseInt(st.nextToken());
            tastes[i][1] = Integer.parseInt(st.nextToken());
        }

        int minTasteDiff = Integer.MAX_VALUE;
        int count = (int) Math.pow(2, n) - 1;
        for (int i = 1; i <= count; i++) {
            String binaryString = String.format("%1$" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            int sour = 1;
            int bitter = 0;
            int len = binaryString.length();
            for (int j = len - 1; j >= 0; j--) {
                if (binaryString.charAt(j) == '1') {
                    sour *= tastes[j][0];
                    bitter += tastes[j][1];
                }
            }
            minTasteDiff = Math.min(minTasteDiff, (int) Math.abs(sour - bitter));
        }
        System.out.println(minTasteDiff);
    }
}
