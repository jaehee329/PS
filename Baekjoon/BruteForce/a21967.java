import java.io.*;
import java.util.*;

public class a21967 {

    private static int n;
    private static int[] nums = new int[11];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            nums[arr[i]]++;
            dq.addLast(arr[i]);
            while (getDiff() > 2 && !dq.isEmpty()) {
                int old = dq.pollFirst();
                nums[old]--;
            }
            max = Math.max(max, dq.size());
        }
        System.out.println(max);
    }

    private static int getDiff() {
        int max = 0;
        for (int i = 1; i <= 10; i++) {
            if (nums[i] != 0) {
                max = i;
            }
        }
        int min = 0;
        for (int i = 10; i >= 1; i--) {
            if (nums[i] != 0) {
                min = i;
            }
        }
        return max - min;
    }
}
