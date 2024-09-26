// by Binary Search
import java.io.*;
import java.util.*;

public class a1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] a = new int[aSize];
        for (int i = 0; i < aSize; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        st = new StringTokenizer(br.readLine());
        int[] b = new int[bSize];
        for (int i = 0; i < bSize; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b);

        int diffCount = 0;
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < aSize; i++) {
            int element = a[i];
            if (!binarySearch(b, element)) {
                diffCount++;
                sj.add(Integer.toString(element));
            }
        }

        System.out.println(diffCount);
        if (diffCount != 0) {
            System.out.println(sj.toString());
        }
    }

    private static boolean binarySearch(int[] arr, int element) {
        return binarySearch(arr, 0, arr.length - 1, element);
    }

    private static boolean binarySearch(int[] arr, int low, int high, int element) {
        if (low > high) {
            return false;
        }
        
        int mid = (low + high) / 2;

        if (arr[mid] < element) {
            return binarySearch(arr, mid + 1, high, element);
        } else if (arr[mid] > element) {
            return binarySearch(arr, low, mid - 1, element);
        } else {
            return true;
        }
    }
}
