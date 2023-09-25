import java.io.*;
import java.util.*;

public class a2512 {

    private static int n;
    private static int[] requests;
    private static int budget;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        requests = new int[n];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int request = Integer.parseInt(st.nextToken());
            sum += request;
            max = Math.max(request, max);
            requests[i] = request;
        }
        budget = Integer.parseInt(br.readLine());
        
        if (sum <= budget) {
            System.out.println(max);
            return;
        }
        
        int low = 0;
        int high = max;
        System.out.println(binarySearch(low, high));
    }

    private static int binarySearch(int low, int high) {
        int mid = (low + high) / 2;
        Integer[] result = getUse(mid);
        int usage = result[0];
        int overRequested = result[1];
        if (usage <= budget - overRequested) {
            return binarySearch(mid + 1, high);
        } else if (usage > budget - overRequested && usage <= budget) {
            return mid;
        } else {
            return binarySearch(low, mid - 1);
        }
    }

    private static Integer[] getUse(int target) {
        int sum = 0;
        int overRequested = 0;
        for (int i = 0; i < n; i++) {
            if (requests[i] > target) {
                sum += target;
                overRequested++;
            } else {
                sum += requests[i];
            }
        }
        return new Integer[]{sum, overRequested};
    }
}
