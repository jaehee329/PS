import java.io.*;
import java.util.*;

public class a24060 {

    private static int k = 0;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(-1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int idx1 = start;
        int idx2 = mid + 1;
        int[] tmp = new int[end - start + 1];
        int tmpIdx = 0;
        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2]) {
                tmp[tmpIdx++] = arr[idx1++];
            } else {
                tmp[tmpIdx++] = arr[idx2++];
            }
        }
        while (idx1 <= mid) {
            tmp[tmpIdx++] = arr[idx1++];
        }
        while (idx2 <= end) {
            tmp[tmpIdx++] = arr[idx2++];
        }
        idx1 = start;
        tmpIdx = 0;
        while (idx1 <= end) {
            arr[idx1++] = tmp[tmpIdx++];
            cnt++;
            if (cnt == k) {
                System.out.println(arr[idx1 - 1]);
                System.exit(0);
            }
        }
    }
}
