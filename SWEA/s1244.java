import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class s1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int change = Integer.parseInt(st.nextToken());
            int maximum = getMaxByChange(Integer.toString(num), change);
            System.out.println("#" + i + " " + maximum);
        }
    }

    public int getMaxByChange(String num, int change) {
        if (num.length() == 2) {
            if (change % 2 == 1) {
                String prefix = num.substring(0, 1);
                String suffix = num.substring(1);
                return Integer.parseInt(prefix + suffix);
            }
            return Integer.parseInt(num);
        }
        
        
    }
}
