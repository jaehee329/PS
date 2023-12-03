import java.io.*;
import java.util.*;

public class a24051 {
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

        insertionSort(arr, k);
    }

    private static void insertionSort(int[] arr, int k) {
        int cnt = 0;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int targetIdx = i - 1;
            int value = arr[i];
            while (targetIdx >= 0 && arr[targetIdx] > value) {
                arr[targetIdx + 1] = arr[targetIdx];
                targetIdx--;
                cnt++;
                if (cnt == k) {
                    System.out.println(arr[targetIdx + 1]);
                    return;
                }
            }
            if (targetIdx + 1 != i) {
                arr[targetIdx + 1] = value;
                cnt++;
                if (cnt == k) {
                    System.out.println(arr[targetIdx + 1]);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
