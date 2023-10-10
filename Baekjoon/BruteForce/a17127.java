import java.io.*;
import java.util.*;

public class a17127 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i <= n - 3; i++) {
            for (int j = i + 1; j <= n - 2; j++) {
                for (int k = j + 1; k <= n - 1; k++) {
                    max = Math.max(getSum(num, i, j, k), max);
                }
            }
        }
        System.out.println(max);
    }

    private static int getSum(int[] num, int i, int j, int k) {
        int n = num.length;
        int first = 1;
        for (int x = 0; x < i; x++) {
            first *= num[x];
        }
        int second = 1;
        for (int y = i; y < j; y++) {
            second *= num[y];
        }
        int third = 1;
        for (int z = j; z < k; z++) {
            third *= num[z];
        }
        int forth = 1;
        for (int w = k; w < n; w++) {
            forth *= num[w];
        }
        return first + second + third + forth;
    }
}
