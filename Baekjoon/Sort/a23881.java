import java.io.*;
import java.util.*;

public class a23881 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        selection_sort(arr, k);
    }

    private static void selection_sort(int[] arr, int k) {
        int changeCount = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            int max = arr[i];
            int maxIdx = -1;
            for (int j = 0; j <= i; j++) {
                if (max < arr[j]) {
                    maxIdx = j;
                    max = arr[j];
                }
            }
            if (max != arr[i]) {
                changeCount++;
                if (changeCount == k) {
                    System.out.println(Math.min(max, arr[i]) + " " + Math.max(max, arr[i]));
                    return;
                }
                int temp = arr[i];
                arr[i] = max;
                arr[maxIdx] = temp;
            }
        }
        System.out.println(-1);
    }
}
