import java.io.*;
import java.util.*;

public class a1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        System.out.println(recursive(n, row, col));
    }

    private static int recursive(int n, int row, int col) {
        if (n == 0) {
            return 0;
        }
        int len = (int) Math.pow(2, n);
        int total = len * len;
        int half = (int) Math.pow(2, n - 1);
        int offset = 0;
        if (row >= half) {
            offset += total / 2;
            row -= half;
        }
        if (col >= half) {
            offset += total / 4;
            col -= half;
        }
        return offset + recursive(n - 1, row, col);
    }
}
