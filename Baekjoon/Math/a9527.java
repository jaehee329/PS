import java.io.*;
import java.util.*;

public class a9527 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long small = onesUnderGivenLong(Long.parseLong(st.nextToken())-1);
        long large = onesUnderGivenLong(Long.parseLong(st.nextToken()));
        System.out.println(large-small);
    }
    private static long onesUnderGivenLong(long l) {
        long cnt = 0;
        int i = 0;
        long target = l+1;
        while(true) {
            long t = (long)Math.pow(2, i);
            cnt += (target / (t*2)) * t;
            cnt += Math.max(target % (t*2) - t, 0);
            if (t > l) {
                break;
            }
            i++;
        }
        return cnt;
    }
}
