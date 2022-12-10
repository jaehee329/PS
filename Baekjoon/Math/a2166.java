import java.io.*;
import java.util.*;

public class a2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] coord = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coord[i][0] = Integer.parseInt(st.nextToken());
            coord[i][1] = Integer.parseInt(st.nextToken());
        }
        coord[n][0] = coord[0][0];
        coord[n][1] = coord[0][1];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long)coord[i][0] * (long)coord[i+1][1] - (long)coord[i+1][0] * (long)coord[i][1];
        }
        System.out.printf("%.1f", (double)Math.abs(sum)/2);
    }
}