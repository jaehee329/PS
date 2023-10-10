import java.io.*;
import java.util.*;

public class a1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int[] importance = new int[cnt];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cnt; j++) {
                importance[j] = Integer.parseInt(st.nextToken());
            }
            int order = calcOrder(cnt, target, importance);
            bw.write(order + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int calcOrder(int cnt, int target, int[] importance) {
        int order = 0;
        int targetImportance = importance[target];
        int lastIdx = -1;
        for (int i = 9; i > targetImportance ; i--) {
            int tmpLastIndex = lastIdx;
            for (int j = lastIdx + 1; j <= lastIdx + cnt; j++) {
                int index = j < cnt ? j : j - cnt;
                if (importance[index] == i) {
                    order++;
                    tmpLastIndex = index;
                }
            }
            lastIdx = tmpLastIndex;
        }

        for (int i = lastIdx + 1; i <= lastIdx + cnt; i++) {
            int index = i < cnt ? i : i - cnt;
            if (index == target) {
                return order + 1;
            }
            if (importance[index] == targetImportance) {
                order++;
            }
        }
        return -1;
    }
}
