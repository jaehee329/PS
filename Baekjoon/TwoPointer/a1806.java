import java.io.*;
import java.util.*;

public class a1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int minLength = Integer.MAX_VALUE;

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int head = 0;
        int tail = 0;
        int sum = 0;
        while (tail < n) {
            if (sum < target) {
                if (head == n) {
                    break;
                }
                sum += arr[head];
                head++;
            } else {
                sum -= arr[tail];
                tail++;
            }
            if (sum >= target) {
                minLength = Math.min(minLength, head - tail);
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(minLength);
    }
}
