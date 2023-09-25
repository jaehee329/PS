import java.io.*;
import java.util.*;

public class a2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int unitCount = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        int[] lengths = new int[6];
        int maxIdx = -1;
        int max = 0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int length = Integer.parseInt(st.nextToken());
            lengths[i] = length;
            if (length > max) {
                max = length;
                maxIdx = i;
            }
        }

        if (lengths[getCircularIdx(maxIdx, 1)] > lengths[getCircularIdx(maxIdx, -1)]) {
            int big = max * lengths[getCircularIdx(maxIdx, 1)];
            int small = lengths[getCircularIdx(maxIdx, 3)] * lengths[getCircularIdx(maxIdx, 4)];
            System.out.println((big - small) * unitCount);
        } else {
            int big = max * lengths[getCircularIdx(maxIdx, -1)];
            int small = lengths[getCircularIdx(maxIdx, 2)] * lengths[getCircularIdx(maxIdx, 3)];
            System.out.println((big - small) * unitCount);
        }
    }

    private static int getCircularIdx(int idx, int distance) {
        int target = idx + distance;
        if (target >= 6) {
            return target - 6;
        } else if (target < 0) {
            return target + 6;
        } else {
            return target;
        }
    }
}
