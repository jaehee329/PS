import java.io.*;
import java.util.*;

public class a20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCount = Integer.parseInt(st.nextToken());
        int countLimit = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] elements = new int[totalCount];
        for (int i = 0; i < totalCount; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }

        int[] arrayElementCount = new int[100_000 + 1];
        int maxLength = 0;
        int headIdx = 0;
        int tailIdx = 0;
        for (int i = 0; i < totalCount; i++) {
            int element = elements[i];
            while (arrayElementCount[element] >= countLimit) {
                arrayElementCount[elements[tailIdx]] -= 1;
                tailIdx++;
            }
            arrayElementCount[element]++;
            if (maxLength < headIdx - tailIdx + 1) {
                maxLength = headIdx - tailIdx + 1;
            }
            headIdx++;
        }
        System.out.println(maxLength);
    }
}
