import java.io.*;
import java.util.*;

public class a12101 {

    private static int[] cases = new int[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        cases[1] = 1;
        cases[2] = 2;
        cases[3] = 4;
        for (int i = 4; i <= 11; i++) {
            cases[i] = cases[i - 1] + cases[i - 2] + cases[i - 3];
        }

        if (cases[n] < k) {
            System.out.println(-1);
            return;
        }

        System.out.println(recurse(n, k));
    }

    private static String recurse(int n, int k) {
        if (n == 1 && k == 1) {
            return "1";
        } else if (n == 2) {
            switch (k) {
                case 1: return "1+1";
                case 2: return "2";
            }
        } else if (n == 3) {
            switch (k) {
                case 1: return "1+1+1";
                case 2: return "1+2";
                case 3: return "2+1";
                case 4: return "3";
            }
        }

        if (k <= cases[n - 1]) {
            return "1+" + recurse(n - 1, k);
        } else if (k <= cases[n - 1] + cases[n - 2]) {
            return "2+" + recurse(n - 2, k - cases[n - 1]);
        } else {
            return "3+" + recurse(n - 3, k - cases[n - 1] - cases[n - 2]);
        }
    }
}
