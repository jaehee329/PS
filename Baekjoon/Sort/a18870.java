import java.util.*;
import java.io.*;

class a18870 {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      int[] nums = new int[N];
      int[] sorted = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
         nums[i] = sorted[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(sorted);
      HashMap<Integer, Integer> map = new HashMap<>();
      int r = 0;
      for (int i : sorted) {
         if (!map.containsKey(i)) {
            map.put(i, r);
            r++;
         }
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < N; i++) {
         sb.append(map.get(nums[i]) + " ");
      }
      System.out.println(sb);
   }
}