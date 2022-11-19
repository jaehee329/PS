import java.io.*;
import java.util.*;

public class a1068{
   static int N;
   static int[] arr;
   static boolean[] isDeleted;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      N = Integer.parseInt(br.readLine());
      arr = new int[N];
      isDeleted = new boolean[N];
      HashSet<Integer> parents = new HashSet<>();
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; i++) {
         arr[i] = Integer.parseInt(st.nextToken());
         isDeleted[i] = false;
      }
      
      int remove = Integer.parseInt(br.readLine());
      isDeleted[remove] = true;
      Queue<Integer> queue = new LinkedList<Integer>();
      queue.add(remove);
      while(!queue.isEmpty()) {
         int first = queue.poll();
         for(int i=0; i<N; i++) {
            if(first == arr[i] && !isDeleted[i]) {
               isDeleted[i] = true;
               queue.add(i);
            }
         }
      }
      for(int i=0; i<N; i++) {
         if(!isDeleted[i] && arr[i] >= 0) {
            parents.add(arr[i]);
         }
      }
      int leaf = 0;
      for(int i=0; i<N; i++) {
         if(!isDeleted[i] && !parents.contains(i)) {
            ++leaf;
         }
      }
      System.out.println(leaf);
   }
   
}