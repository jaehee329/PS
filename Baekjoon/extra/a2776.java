import java.io.*;
import java.util.*;


public class a2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner("\n");
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int note1Size = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>(note1Size);
    
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int element = Integer.parseInt(st.nextToken());
                set.add(element);
            }
        
            int note2Size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int element = Integer.parseInt(st.nextToken());
                if (set.contains(element)) {
                    sj.add("1");
                } else {
                    sj.add("0");
                }
            }
        }
    
        System.out.println(sj.toString());
    }
}
