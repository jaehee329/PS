import java.io.*;
import java.util.*;

public class a1497 {
    private static int n;
    private static int m;
    private static long[] state = new long[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String availability = st.nextToken();
            for (int j = m - 1; j >= 0; j--) {
                state[i] = (state[i] << 1) | (availability.charAt(j) == 'Y' ? 1 : 0);
            }
        }

        int maxSongs = 0;
        int minGuitars = -1;

        for (int mask = 0; mask < (1 << n); mask++) {
            long comb = 0;
            int guitarCount = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    comb |= state[i];
                    guitarCount++;
                }
            }

            int songCount = bitCount(comb);

            if (songCount > maxSongs) {
                maxSongs = songCount;
                minGuitars = guitarCount;
            } else if (songCount == maxSongs && (minGuitars == -1 || guitarCount < minGuitars)) {
                minGuitars = guitarCount;
            }
        }

        System.out.println(maxSongs == 0 ? -1 : minGuitars);
    }

    private static int bitCount(long x) {
        int count = 0;
        for (int i = 0; i < Math.max(n, m); i++) {
            count += (x >> i) & 1;
        }
        return count;
    }
}

