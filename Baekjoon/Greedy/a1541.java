import java.io.*;
import java.util.*;

public class a1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");
        boolean isFirst = true;
        int minSum = 0;
        while (st1.hasMoreTokens()) {
            int partialSum = 0;
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
            while (st2.hasMoreTokens()) {
                partialSum += Integer.parseInt(st2.nextToken());
            }
            if (isFirst) {
                minSum += partialSum;
                isFirst = false;
            } else {
                minSum -= partialSum;
            }
        }
        System.out.println(minSum);
    }
}
