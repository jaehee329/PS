import java.io.*;
import java.util.*;

public class a1182 {

    private static int length;
    private static int targetSum;
    private static int[] arr;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st.nextToken());
        targetSum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count(0, 0);

        if (targetSum == 0) {
            count--;
        }
        System.out.println(count);
    }

    private static void count(int elemCount, int currentSum) {
        if (elemCount == length) {
            if (currentSum == targetSum) {
                count++;
            }
            return;
        }
        count(elemCount + 1, currentSum);
        count(elemCount + 1, currentSum + arr[elemCount]);
    }
}
