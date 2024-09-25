import java.io.*;
import java.util.*;

public class a2295 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {
                sums.add(arr[i] + arr[j]);
            }
        }

        for (int i = count - 1; i >= 0; i--) {
            int target = arr[i];
            for (int j = 0; j <= i; j++) {
                int diff = target - arr[j];
                if (sums.contains(diff)) {
                    System.out.println(target);
                    return;
                }
            }
        }
    }
}