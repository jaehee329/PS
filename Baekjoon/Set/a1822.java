// by Set
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
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < bSize; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        int diffCount = 0;
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < aSize; i++) {
            int element = a[i];
            if (!b.contains(element)) {
                diffCount++;
                sj.add(Integer.toString(element));
            }
        }

        System.out.println(diffCount);
        if (diffCount != 0) {
            System.out.println(sj.toString());
        }
    }
}
